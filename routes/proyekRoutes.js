const express = require('express');
const router = express.Router();
const proyekController = require('../controllers/proyekController');
const Proyek = require('../models/proyek');

// Simulasi buat role
const role = 'mandor'; // untuk admin view

router.get('/', (req, res) => {
    const proyek = proyekController.getAll();
    res.render('index', { role });
});

router.get('/mandor', (req, res) => {
    const proyek = proyekController.getAll();
    res.render('mandor', { proyek });
});

router.post('/mandor', (req, res) => {
    const { nama, tanggalMulai, status } = req.body;
    const proyek = new Proyek(nama, tanggalMulai, status, false);
    proyekController.create(proyek);
    res.redirect('/mandor');
});

router.post('/mandor/delete', (req, res) => {
    proyekController.delete(req.body.nama);
    res.redirect('/mandor');
});

router.get('/admin', (req, res) => {
    const proyek = proyekController.getAll();
    res.render('admin', { proyek });
});

module.exports = router;