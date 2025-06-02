class Proyek {
    constructor(nama, tanggalMulai, status, selesaiDikerjakan = false) {
        this.nama = nama;
        this.tanggalMulai = tanggalMulai;
        this.status = status; // 'instal' / 'non-instal'
        this.selesaiDikerjakan = selesaiDikerjakan;
        console.log(Proyek "${this.nama}" dibuat.);
    }

    destroy() {
        console.log(Proyek "${this.nama}" dihapus dari memori.);
    }
}

module.exports = Proyek;