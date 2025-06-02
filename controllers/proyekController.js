const fs = require('fs');
const path = './data/proyek.json';
const Proyek = require('../models/proyek');

function loadProyek() {
    if (!fs.existsSync(path)) return [];
    return JSON.parse(fs.readFileSync(path));
}

function saveProyek(data) {
    fs.writeFileSync(path, JSON.stringify(data, null, 2));
}

const proyekController = {
    getAll: () => loadProyek(),
    create: (proyek) => {
        const data = loadProyek();
        data.push(proyek);
        saveProyek(data);
    },
    delete: (nama) => {
        let data = loadProyek();
        data = data.filter(p => p.nama !== nama);
        saveProyek(data);
    }
};

module.exports = proyekController