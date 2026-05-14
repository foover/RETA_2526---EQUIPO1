/* ═══════════════════════════════════════════
   main.js — Lógica de interacción + fetch
   La única diferencia respecto a la versión PHP:
   la URL de la API es /api?codigo=N
   en vez de api.php?codigo=N
════════════════════════════════════════════ */

(function () {
  'use strict';

  // ── URL de la API (Node.js la atiende en /api) ────────
  const API_URL = '/api';

  // ── Referencias al DOM ────────────────────────────────
  const panel        = document.getElementById('info-panel');
  const elCodigo     = document.getElementById('info-codigo');
  const elTitle      = document.getElementById('info-title');
  const elLoading    = document.getElementById('info-loading');
  const elError      = document.getElementById('info-error');
  const elTablaWrap  = document.getElementById('info-tabla-wrap');
  const elTbody      = document.getElementById('info-tbody');
  const elVacio      = document.getElementById('info-vacio');
  const closeBtn     = document.getElementById('info-close');

  let selectedCell = null;

  // ── Estados del panel ─────────────────────────────────
  function showLoading() {
    elLoading.style.display   = 'flex';
    elError.style.display     = 'none';
    elTablaWrap.style.display = 'none';
    elVacio.style.display     = 'none';
  }

  function showError(msg) {
    elLoading.style.display   = 'none';
    elTablaWrap.style.display = 'none';
    elVacio.style.display     = 'none';
    elError.style.display     = 'block';
    elError.textContent       = '⚠ ' + msg;
  }

  function showTabla(filas) {
    elLoading.style.display = 'none';
    elError.style.display   = 'none';

    if (filas.length === 0) {
      elTablaWrap.style.display = 'none';
      elVacio.style.display     = 'block';
      return;
    }

    elVacio.style.display     = 'none';
    elTablaWrap.style.display = 'block';
    elTbody.innerHTML         = '';

    filas.forEach(function (item) {
      const tr = document.createElement('tr');

      const cols = [
        item.nombre,
        item.categoria + ' / ' + item.subcategoria,
        item.cantidad,
        null,   // estado → badge
        item.observaciones || '—',
      ];

      cols.forEach(function (val, i) {
        const td = document.createElement('td');
        if (i === 3) {
          // Badge de estado
          const badge = document.createElement('span');
          badge.className   = 'badge badge-' + item.estado.replace(' ', '-');
          badge.textContent = item.estado;
          td.appendChild(badge);
        } else {
          td.textContent = val;
        }
        tr.appendChild(td);
      });

      elTbody.appendChild(tr);
    });
  }

  // ── Fetch a la API ────────────────────────────────────
  function fetchUbicacion(codigo) {
    showLoading();

    fetch(API_URL + '?codigo=' + encodeURIComponent(codigo))
      .then(function (res) {
        if (!res.ok) throw new Error('Error HTTP ' + res.status);
        return res.json();
      })
      .then(function (data) {
        if (data.error) {
          showError(data.error);
        } else {
          showTabla(data);
        }
      })
      .catch(function (err) {
        showError('No se pudo conectar con el servidor. ' + err.message);
      });
  }

  // ── Abrir / cerrar panel ──────────────────────────────
  function openPanel(cell) {
    elCodigo.textContent = 'Ubicación #' + cell.dataset.codigo;
    elTitle.textContent  = cell.dataset.label;
    panel.classList.add('visible');
    fetchUbicacion(cell.dataset.codigo);
  }

  function closePanel() {
    panel.classList.remove('visible');
    if (selectedCell) {
      selectedCell.classList.remove('selected');
      selectedCell = null;
    }
  }

  // ── Eventos ───────────────────────────────────────────
  function handleCellClick(e) {
    const cell = e.currentTarget;
    if (cell === selectedCell) { closePanel(); return; }
    if (selectedCell) selectedCell.classList.remove('selected');
    selectedCell = cell;
    cell.classList.add('selected');
    openPanel(cell);
  }

  function init() {
    document.querySelectorAll('.celda').forEach(function (c) {
      c.addEventListener('click', handleCellClick);
    });
    closeBtn.addEventListener('click', closePanel);
    document.addEventListener('keydown', function (e) {
      if (e.key === 'Escape') closePanel();
    });
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }

})();
