package com.example.raionhackjam.geminiAPI

data class DummyData(
    val id: Int,
    val namaPanggilan: String,
    val tagAkun: String,
    val rating: String,
    val deskripsi: String,
    val tagas: List<String>
)

val allFreelancers = listOf(

    // Kategori: Pertukangan & Renovasi (4 orang)
    DummyData(
        id = 1,
        namaPanggilan = "Pak Eko",
        tagAkun = "@EkoSiSerbaBisa",
        rating = "4.9/5 (152 ulasan)",
        deskripsi = """
            Spesialis perbaikan listrik seperti stop kontak dan instalasi lampu. Menerima juga perbaikan ledeng (keran bocor, saluran mampet), dan pertukangan ringan. Berpengalaman lebih dari 15 tahun dalam bidang renovasi kecil.
        """.trimIndent(),
        tagas = listOf("Tukang Listrik", "Tukang Ledeng", "Tukang Serba Bisa")
    ),
    DummyData(
        id = 2,
        namaPanggilan = "Budi",
        tagAkun = "@BudiPerkakas",
        rating = "4.8/5 (95 ulasan)",
        deskripsi = """
            Tukang modern dan gesit. Spesialis merakit furnitur (IKEA, Informa), pasang bracket TV, dan instalasi smart home ringan. Jika Anda butuh bantuan pertukangan yang cepat dan rapi, saya siap membantu.
        """.trimIndent(),
        tagas = listOf("Tukang Perkakas", "Tukang Rakitan", "Tukang Serba Bisa")
    ),
    DummyData(
        id = 3,
        namaPanggilan = "Agus",
        tagAkun = "@AgusCatDinding",
        rating = "4.8/5 (88 ulasan)",
        deskripsi = """
            Jasa pengecatan profesional untuk dinding interior dan eksterior rumah, ruko, atau kos. Hasil pengecatan dijamin rapi dan bersih. Menerima juga pengecatan pagar dan pintu. Siap membuat properti Anda terlihat baru lagi.
        """.trimIndent(),
        tagas = listOf("Tukang Cat", "Tukang Pengecatan", "Tukang Serba Bisa")
    ),
    DummyData(
        id = 4,
        namaPanggilan = "Haryanto",
        tagAkun = "@HaryantoLas",
        rating = "4.9/5 (75 ulasan)",
        deskripsi = """
            Tukang las berpengalaman untuk perbaikan dan pembuatan pagar, kanopi, teralis, dan tangga besi. Pekerjaan pengelasan kuat dan presisi. Siap mengerjakan proyek renovasi yang berhubungan dengan besi.
        """.trimIndent(),
        tagas = listOf("Tukang Las", "Tukang Besi", "Tukang Serba Bisa")
    ),

    // Kategori: Jasa Kebersihan (3 orang)
    DummyData(
        id = 5,
        namaPanggilan = "Ibu Susi",
        tagAkun = "@SusiKinclong",
        rating = "5.0/5 (88 ulasan)",
        deskripsi = """
            Menawarkan jasa kebersihan harian atau borongan untuk rumah, apartemen, dan kos. Layanan meliputi sapu, pel, lap debu, membersihkan kamar mandi, dan setrika. Rumah dijamin bersih dan wangi.
        """.trimIndent(),
        tagas = listOf("Jasa Kebersihan", "Cleaning Service", "Pembersih Rumah")
    ),
    DummyData(
        id = 6,
        namaPanggilan = "Tim Kinclong Malang",
        tagAkun = "@KinclongMLG",
        rating = "4.8/5 (180 ulasan)",
        deskripsi = """
            Kami adalah tim jasa kebersihan profesional. Menerima deep cleaning, pembersihan pasca-renovasi, dan vakum tungau untuk sofa/kasur. Datang dengan tim dan peralatan lengkap untuk hasil maksimal.
        """.trimIndent(),
        tagas = listOf("Jasa Kebersihan", "Cleaning Service", "Pembersih Rumah")
    ),
    DummyData(
        id = 7,
        namaPanggilan = "Pak Tarno",
        tagAkun = "@TarnoTaman",
        rating = "4.9/5 (60 ulasan)",
        deskripsi = """
            Spesialis perawatan taman dan kebun. Siap membantu merapikan taman Anda, mulai dari potong rumput, pangkas tanaman, pemupukan, hingga membersihkan daun kering. Taman kembali asri dan bersih.
        """.trimIndent(),
        tagas = listOf("Perawatan Taman", "Jasa Kebersihan", "Pembersih Rumah")
    ),

    // Kategori: Desain Grafis & Digital (3 orang)
    DummyData(
        id = 8,
        namaPanggilan = "Rina",
        tagAkun = "@RinaCreative",
        rating = "4.8/5 (45 ulasan)",
        deskripsi = """
            Mahasiswi DKV siap membantu kebutuhan desain Anda! Menerima pengerjaan logo untuk UMKM, konten media sosial (Instagram feed & story), dan edit foto produk. Desain modern, cepat, dan harga bersahabat.
        """.trimIndent(),
        tagas = listOf("Desain Grafis", "Edit Foto", "Konten Media Sosial")
    ),
    DummyData(
        id = 9,
        namaPanggilan = "Santi",
        tagAkun = "@SantiVisual",
        rating = "4.9/5 (68 ulasan)",
        deskripsi = """
            Desainer grafis dengan pengalaman 5 tahun. Fokus pada desain premium untuk branding dan marketing kit. Juga menerima jasa edit video pendek untuk TikTok/Reels. Mari tingkatkan visual usaha Anda.
        """.trimIndent(),
        tagas = listOf("Desain Grafis", "Edit Video", "Konten Media Sosial")
    ),
    DummyData(
        id = 10,
        namaPanggilan = "Gilang",
        tagAkun = "@GilangWords",
        rating = "4.8/5 (35 ulasan)",
        deskripsi = """
            Jasa penulisan artikel SEO, copywriting untuk media sosial, dan terjemahan dokumen Inggris-Indonesia (non-resmi). Konten dijamin original dan riset mendalam untuk kebutuhan marketing Anda.
        """.trimIndent(),
        tagas = listOf("Penulis Konten", "Copywriter", "Penerjemah")
    ),

    // Kategori: Transportasi & Logistik (3 orang)
    DummyData(
        id = 11,
        namaPanggilan = "Asep",
        tagAkun = "@AsepAngkut",
        rating = "4.7/5 (110 ulasan)",
        deskripsi = """
            Siap menjadi tenaga bantuan untuk pindahan rumah/kantor, angkat barang berat, buang puing bangunan, atau bantuan logistik acara. Fisik kuat, kerja cepat, dan bisa datang bersama tim.
        """.trimIndent(),
        tagas = listOf("Bantu Angkut", "Pindahan", "Bongkar Muat")
    ),
    DummyData(
        id = 12,
        namaPanggilan = "Dani",
        tagAkun = "@DaniAngkutPikep",
        rating = "4.7/5 (88 ulasan)",
        deskripsi = """
            Menyediakan jasa angkut barang dengan mobil pickup bak terbuka. Sudah termasuk sopir dan bisa menyediakan 1 tenaga angkut tambahan. Cocok untuk pindahan kos atau kirim barang besar dalam kota.
        """.trimIndent(),
        tagas = listOf("Bantu Angkut", "Pindahan", "Bongkar Muat")
    ),
    DummyData(
        id = 13,
        namaPanggilan = "Rizky",
        tagAkun = "@RizkyKurirCepat",
        rating = "4.9/5 (210 ulasan)",
        deskripsi = """
            Jasa kurir instan dengan motor untuk pengiriman dokumen, makanan, atau barang kecil di area Malang Raya. Cepat, amanah, dan siap dihubungi kapan saja Anda butuh pengiriman mendadak.
        """.trimIndent(),
        tagas = listOf("Kurir", "Pengiriman", "Antar Barang")
    ),

    // Kategori: Jasa Acara (3 orang)
    DummyData(
        id = 14,
        namaPanggilan = "Dika",
        tagAkun = "@DikaEventHelper",
        rating = "4.9/5 (30 ulasan)",
        deskripsi = """
            Freelancer berpengalaman sebagai kru acara (event crew), fotografer dokumentasi, dan asisten pribadi untuk berbagai acara seperti pernikahan, seminar, atau pameran. Cekatan dan solutif di lapangan.
        """.trimIndent(),
        tagas = listOf("Kru Acara", "Fotografer", "Asisten Pribadi")
    ),
    DummyData(
        id = 15,
        namaPanggilan = "Wulan",
        tagAkun = "@WulanMUA",
        rating = "4.9/5 (55 ulasan)",
        deskripsi = """
            Makeup Artist (MUA) untuk acara wisuda, lamaran, pesta, dan bridesmaid. Makeup natural dan flawless sesuai permintaan. Bisa datang ke lokasi Anda. Mari buat momen spesial Anda lebih berkesan.
        """.trimIndent(),
        tagas = listOf("Makeup Artist", "MUA", "Perias Wajah")
    ),
    DummyData(
        id = 16,
        namaPanggilan = "Bu Retno",
        tagAkun = "@DapurBuRetno",
        rating = "4.9/5 (72 ulasan)",
        deskripsi = """
            Menerima pesanan katering nasi kotak atau tumpeng mini untuk acara kecil seperti arisan dan rapat kantor. Juga menyediakan jasa bantuan masak untuk persiapan acara besar di rumah Anda.
        """.trimIndent(),
        tagas = listOf("Katering", "Jasa Masak", "Catering")
    ),

    // Kategori: Edukasi & Keahlian (2 orang)
    DummyData(
        id = 17,
        namaPanggilan = "Fira",
        tagAkun = "@FiraMengajar",
        rating = "5.0/5 (25 ulasan)",
        deskripsi = """
            Mahasiswi Sastra Inggris menawarkan les privat Bahasa Inggris untuk tingkat SD-SMP. Juga bisa membantu mengerjakan PR Matematika dasar. Metode mengajar seru dan sabar. Siap datang ke rumah.
        """.trimIndent(),
        tagas = listOf("Guru Les Privat", "Les Bahasa Inggris", "Tutor Matematika")
    ),
    DummyData(
        id = 18,
        namaPanggilan = "Andi",
        tagAkun = "@AndiGitar",
        rating = "4.9/5 (40 ulasan)",
        deskripsi = """
            Guru les privat gitar akustik untuk pemula, semua usia. Pengajaran dari nol, mulai dari pengenalan kunci dasar hingga mampu memainkan lagu favorit. Jadwal fleksibel.
        """.trimIndent(),
        tagas = listOf("Guru Les Privat", "Les Gitar", "Tutor Musik")
    ),

    // Kategori: Perawatan Hewan & Lainnya (2 orang)
    DummyData(
        id = 19,
        namaPanggilan = "Kevin",
        tagAkun = "@KevinPetCare",
        rating = "5.0/5 (40 ulasan)",
        deskripsi = """
            Pecinta hewan! Menerima jasa dog walking, cat sitting (kunjungan ke rumah saat Anda bepergian), dan penitipan hewan kecil seperti kucing atau hamster. Hewan kesayangan Anda dijamin aman dan nyaman.
        """.trimIndent(),
        tagas = listOf("Perawatan Hewan", "Dog Walker", "Pet Sitter")
    ),
    DummyData(
        id = 20,
        namaPanggilan = "Chandra",
        tagAkun = "@ChandraServisAC",
        rating = "4.9/5 (112 ulasan)",
        deskripsi = """
            Teknisi AC berpengalaman. Menerima jasa cuci AC rutin, perbaikan (AC tidak dingin, bocor air), isi freon, dan bongkar-pasang AC untuk semua merek. Servis AC Anda agar kembali sejuk.
        """.trimIndent(),
        tagas = listOf("Teknisi AC", "Servis AC", "Perbaikan AC")
    )
)