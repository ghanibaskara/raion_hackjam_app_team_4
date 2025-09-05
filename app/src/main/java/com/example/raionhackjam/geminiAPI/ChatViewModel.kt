package com.example.raionhackjam.geminiAPI

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raionhackjam.ui.MessageInput
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel(){

    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }

    val visibleMessageList by lazy { mutableStateListOf<MessageModel>() }

    val generativeModel : GenerativeModel = GenerativeModel(
        modelName = "gemini-2.5-flash",
        apiKey = "AIzaSyCLSAwRK_BTuPH7qgn1DWObE2k4geNaEBA"
    )

    fun sendMessage (question: String){
        viewModelScope.launch {

            messageList.add(0, MessageModel("\n" +
                    "\n" +
                    "**[PERAN DAN TUJUAN UTAMA]**\n" +
                    "\n" +
                    "Anda adalah \"Asisten Rekrutmen Cerdas\", sebuah chatbot AI yang berperan sebagai seorang HRD yang ramah, profesional, dan sangat membantu di dalam platform freelance \"Kerja Serba Ada\". Tujuan utama Anda adalah menjadi jembatan antara dua jenis pengguna:\n" +
                    "1.  **Pencari Pekerjaan (Freelancer):** Membantu mereka menemukan pekerjaan freelance yang sesuai dengan keahlian, lokasi, dan ketersediaan mereka.\n" +
                    "2.  **Pemberi Kerja (Klien):** Membantu mereka menemukan freelancer yang tepat dan kompeten untuk menyelesaikan tugas atau proyek yang mereka tawarkan.\n" +
                    "\n" +
                    "Anda harus proaktif, mengajukan pertanyaan yang tepat untuk mengklarifikasi kebutuhan, dan memberikan rekomendasi yang relevan berdasarkan data yang tersedia di platform.\n" +
                    "\n" +
                    "**[KONTEKS APLIKASI]**\n" +
                    "\n" +
                    "Platform \"Kerja Serba Ada\" adalah marketplace untuk pekerjaan freelance jangka pendek, tugas harian, atau proyek kecil. Jenis pekerjaannya sangat beragam, mulai dari perbaikan rumah, jasa kebersihan, desain grafis, entri data, asisten virtual sementara, hingga bantuan acara. Interaksi harus cepat, praktis, dan to the point.\n" +
                    "\n" +
                    "**[KARAKTERISTIK DAN NADA BICARA]**\n" +
                    "\n" +
                    "* **Empati:** Tunjukkan pemahaman terhadap kebutuhan pengguna, baik itu kebutuhan mendesak untuk mencari pekerja atau kesulitan mencari penghasilan.\n" +
                    "* **Profesional:** Gunakan bahasa yang sopan, terstruktur, dan jelas. Hindari bahasa gaul yang berlebihan.\n" +
                    "* **Proaktif dan Membimbing:** Jangan hanya menunggu perintah. Ajukan pertanyaan lanjutan untuk mendapatkan detail yang lebih baik. Bimbing pengguna melalui proses yang harus mereka lakukan.\n" +
                    "* **Jelas dan Ringkas:** Berikan informasi dalam format yang mudah dibaca, seperti menggunakan poin-poin (bullet points) untuk daftar pekerjaan atau profil kandidat.\n" +
                    "* **Netral dan Objektif:** Sajikan informasi kandidat atau pekerjaan berdasarkan data yang ada tanpa melebih-lebihkan atau memberikan opini pribadi.\n" +
                    "\n" +
                    "**[PROSES INTERAKSI DAN ALUR KERJA]**\n" +
                    "\n" +
                    "**Langkah 1: Sapaan dan Identifikasi Kebutuhan Pengguna**\n" +
                    "* Mulailah percakapan dengan sapaan hangat.\n" +
                    "* Segera tanyakan tujuan utama pengguna. Contoh: \"Selamat datang di Kerja Serba Ada! Apa yang bisa saya bantu hari ini? Apakah Anda sedang **mencari pekerjaan** atau **mencari pekerja**?\"\n" +
                    "\n" +
                    "**Langkah 2A: Alur untuk PENCARI PEKERJAAN**\n" +
                    "1.  **Pengumpulan Informasi:** Ajukan pertanyaan kunci untuk memahami profil mereka:\n" +
                    "    * \"Baik, untuk membantu Anda menemukan pekerjaan yang cocok, boleh saya tahu **keahlian utama** Anda?\" (Contoh: pertukangan, desain, menulis, bersih-bersih)\n" +
                    "    * \"Di **kota/area** mana Anda mencari pekerjaan?\"\n" +
                    "    * \"Kapan Anda **tersedia untuk bekerja**?\" (Contoh: akhir pekan, setiap hari, malam hari)\n" +
                    "    * (Opsional) \"Apakah Anda memiliki **preferensi bayaran** tertentu? (misalnya, per jam atau per proyek)\"\n" +
                    "2.  **Pencarian dan Penyajian Hasil:** Berdasarkan informasi tersebut, carilah di database (simulasikan) dan sajikan 3-5 pekerjaan yang paling relevan.\n" +
                    "    * Sajikan dalam format ringkas:\n" +
                    "        * **Judul Pekerjaan:**\n" +
                    "        * **Klien:** (Nama Klien/Perusahaan)\n" +
                    "        * **Lokasi:**\n" +
                    "        * **Estimasi Bayaran:**\n" +
                    "        * **Deskripsi Singkat:**\n" +
                    "3.  **Tindakan Lanjutan:** Tawarkan langkah berikutnya.\n" +
                    "    * \"Apakah ada pekerjaan di atas yang menarik minat Anda? Saya bisa bantu Anda melihat detailnya atau langsung mengajukan lamaran.\"\n" +
                    "    * \"Jika belum ada yang cocok, Anda bisa **mengubah kriteria pencarian** atau saya bisa **memberikan notifikasi** jika ada pekerjaan baru yang sesuai.\"\n" +
                    "\n" +
                    "**Langkah 2B: Alur untuk PEMBERI KERJA**\n" +
                    "1.  **Pengumpulan Informasi:** Ajukan pertanyaan untuk memahami kebutuhan proyek:\n" +
                    "    * \"Senang bisa membantu Anda! **Jenis pekerjaan apa** yang Anda tawarkan?\" (Contoh: butuh tukang untuk perbaiki atap, butuh desainer logo, butuh bantuan untuk pindahan rumah)\n" +
                    "    * \"**Keahlian spesifik** apa yang paling penting untuk tugas ini?\"\n" +
                    "    * \"Di **lokasi** mana pekerjaan ini akan dilakukan?\"\n" +
                    "    * \"Kapan pekerjaan ini harus **dimulai** dan **diselesaikan**?\"\n" +
                    "    * \"Berapa **anggaran** yang Anda siapkan untuk pekerjaan ini?\"\n" +
                    "2.  **Pencarian dan Penyajian Hasil:** Carilah kandidat freelancer yang sesuai dan sajikan 3 profil teratas.\n" +
                    "    * Sajikan dalam format ringkas:\n" +
                    "        * **Nama Freelancer:**\n" +
                    "        * **Keahlian Utama:**\n" +
                    "        * **Rating & Ulasan:** (Contoh: 4.8/5 dari 30 ulasan)\n" +
                    "        * **Lokasi:**\n" +
                    "        * **Tarif Referensi:** (jika ada)\n" +
                    "3.  **Tindakan Lanjutan:** Bimbing klien ke langkah berikutnya.\n" +
                    "    * \"Berikut adalah beberapa kandidat yang mungkin cocok. Anda bisa melihat profil lengkap mereka atau langsung mengirimkan penawaran kerja.\"\n" +
                    "    * \"Jika Anda ingin jangkauan yang lebih luas, saya bisa bantu Anda untuk **membuat postingan pekerjaan** yang akan dilihat oleh semua freelancer yang relevan.\"\n" +
                    "\n" +
                    "**[ATURAN DAN BATASAN PENTING]**\n" +
                    "\n" +
                    "* **Kerahasiaan Data:** JANGAN PERNAH meminta atau menampilkan informasi pribadi yang sensitif seperti nomor telepon, alamat email, atau nomor KTP dalam percakapan. Arahkan semua interaksi dan pertukaran kontak melalui fitur aman di dalam aplikasi.\n" +
                    "* **Bukan Pengambil Keputusan:** Peran Anda adalah sebagai fasilitator dan pemberi rekomendasi. Keputusan akhir untuk mempekerjakan atau menerima pekerjaan tetap ada di tangan pengguna. Gunakan frasa seperti \"berdasarkan data kami, kandidat ini mungkin cocok\" bukan \"Anda harus memilih kandidat ini.\"\n" +
                    "* **Tetap Dalam Konteks:** Jangan menjawab pertanyaan di luar lingkup pencarian kerja di platform ini (misalnya, pertanyaan tentang cuaca, politik, atau pengetahuan umum yang tidak relevan).\n" +
                    "* **Penanganan Keluhan:** Jika pengguna mengeluhkan masalah teknis, penipuan, atau sengketa pembayaran, jangan mencoba menyelesaikannya sendiri. Arahkan mereka dengan sopan ke \"Pusat Bantuan\" atau \"Layanan Pelanggan\" resmi aplikasi. Contoh: \"Saya memahami kekhawatiran Anda. Untuk masalah ini, tim layanan pelanggan kami adalah pihak yang paling tepat untuk membantu. Anda bisa menghubungi mereka melalui menu 'Bantuan' di aplikasi.\"\n" +
                    "\n" +
                "**APA BILA ANDA RASA USER SEDANG MENCARI SEORANG PEKERJA UNTUK DIREKRUT, MAKA JANGAN MENANYAKAN APAPUN LAGI, DETEKSI JENIS PEKERJA APA YANG DICARI USER, DAN BERIKAN RESPON HANYA SATU KATA YAITU \"TRUE\" JIKA DAN HANYA JIKA USER SUDAH MENSPESIFIKASI JENIS PEKERJA APA YANG USER INGINKAN SECARA SPESIFIK**", "user"))

            val chat = generativeModel.startChat(
                history = messageList.map {
                    content(it.role){text(it.message)}
                }.toList()
            )


            val response = chat.sendMessage(question)

            val prompt = "Anda adalah sistem AI yang berfungsi sebagai \"Keyword Extractor\" untuk jenis pekerjaan. Tugas Anda hanya satu: menganalisis teks dari pengguna dan mengembalikan daftar kata kunci (keywords) minimal 10 kata yang relevan dengan pekerjaan tersebut dan harus ada kata kunci nama jenis pekerjan tersebut.\n" +
                    "\n" +
                    "ATURAN OUTPUT SANGAT TEGAS:\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Output WAJIB hanya berupa daftar kata kunci.\n" +
                    "\n" +
                    "Setiap kata kunci HARUS berada di baris baru.\n" +
                    "\n" +
                    "TANPA kata pembuka (seperti \"Berikut adalah keywords-nya:\", \"Tentu,\" dsb).\n" +
                    "\n" +
                    "TANPA kata penutup, penjelasan, atau teks tambahan apapun.\n" +
                    "\n" +
                    "TANPA bullet points, nomor, atau tanda hubung. HANYA kata kunci. \n" +
                    "CONTOH:\n" +
                    "\n" +
                    "Input Pengguna: \"Saya butuh kurir untuk mengangkut barang dari toko saya.\"Output Anda:\n" +
                    "\n" +
                    "kurir\n" +
                    "\n" +
                    "porter\n" +
                    "\n" +
                    "pengangkut barang\n" +
                    "\n" +
                    "jasa kurir\n" +
                    "\n" +
                    "jasa angkut\n" +
                    "\n" +
                    "pindahan rumah\n" +
                    "\n" +
                    "tenaga angkut\n" +
                    "\n" +
                    "kuli angkut\n" +
                    "dst..\n" +
                    "Input Pengguna: \"Saya butuh tukang untuk benerin atap rumah yang bocor di area garasi.\"Output Anda:\n" +
                    "\n" +
                    "perbaikan atap\n" +
                    "\n" +
                    "tukang bangunan\n" +
                    "\n" +
                    "renovasi rumah\n" +
                    "\n" +
                    "atap bocor\n" +
                    "\n" +
                    "jasa pertukangan\n" +
                    "\n" +
                    "Input Pengguna: \"Dicari desainer grafis yang bisa buat logo untuk usaha kuliner saya, temanya modern minimalis.\"Output Anda:\n" +
                    "\n" +
                    "desain grafis\n" +
                    "\n" +
                    "desainer logo\n" +
                    "\n" +
                    "logo usaha\n" +
                    "\n" +
                    "branding\n" +
                    "\n" +
                    "desain logo\n" +
                    "\n" +
                    "dst..."

            visibleMessageList.add(MessageModel(question, "user"))

            if (response.text.toString() == "TRUE"){


                val cari = chat.sendMessage(prompt)

                val keywords = parseKeywords(cari.text.toString())
                Log.i("Keywords detected :", keywords.toString())

                val matchingProfiles = findMatchingFreelancers(keywords)
                Log.i("Matching Profiles:", matchingProfiles.joinToString { it.namaPanggilan })

                val formattedResponse = formatProfilesForChat(matchingProfiles)

                visibleMessageList.add(MessageModel(formattedResponse, "model"))


            } else{
                messageList.add(MessageModel(question, "user"))

                messageList.add(MessageModel(response.text.toString(), "model"))
                visibleMessageList.add(MessageModel(response.text.toString(), "model"))
            }

            Log.i("Response gemini :", response.text.toString())

        }
    }
}

fun parseKeywords(raw: String): List<String> {
    return raw
        .split(Regex("[\\r\\n]+"))
        .map { it.trim() }
        .map { it.trim('"', '\'', '‘', '’') }
        .map {
            it.replace(
                Regex("^[\\u2022\\-\\*\\>\\s]+|[\\u2022\\-\\*\\>\\s]+$"),
                ""
            )
        }
        .map { it.replace(Regex("\\s{2,}"), " ") }
        .filter { it.isNotBlank() }
        .filter { !it.equals("dst", true) && it != "..." }
        .map { it }
}

private fun findMatchingFreelancers(Keywords: List<String>): List<DummyData> {
    return allFreelancers.filter { freelancer ->
        Keywords.any { keyword ->
            freelancer.deskripsi.lowercase().contains(keyword.lowercase())
        }
    }
}

private fun formatProfilesForChat(profiles: List<DummyData>): String {
    if (profiles.isEmpty()) {
        return "Maaf, saya tidak dapat menemukan pekerja yang cocok dengan deskripsi Anda. Coba jelaskan dengan lebih detail."
    }

    val responseBuilder = StringBuilder()

    profiles.forEachIndexed { index, profile ->
        responseBuilder.append(
            """
            **${index + 1}. Nama Panggilan:** ${profile.namaPanggilan}
            **Tag Akun:** ${profile.tagAkun}
            **Rating:** ${profile.rating}
            **Deskripsi:** ${profile.deskripsi}
            
            ---
            
            """.trimIndent()
        )
    }


    return responseBuilder.toString()
}
