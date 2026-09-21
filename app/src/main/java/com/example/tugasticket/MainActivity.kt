package com.example.tugasticket


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun MainScreen() {
    var hargaTiket by rememberSaveable { mutableStateOf(350000) }
    var jumlahTiket by rememberSaveable { mutableStateOf(1) }
    var namaPembeli by rememberSaveable { mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("Silakan pesan tiket") }
    var memproses by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(memproses) {
        if (memproses) {
            status = "Memproses pesanan........."
            delay(5000)
            status = "Tiket telah dipesan"
            memproses = false
        }
    }

    TampilanOrder(
        hargaTiket = hargaTiket,
        jumlahTiket = jumlahTiket,
        namaPembeli = namaPembeli,
        status = status,
        memproses = memproses,
        onNamaPembeliChange = { nama ->
            namaPembeli = nama
        },
        onTambahTiket = {
            jumlahTiket++
        },
        onKurangTiket = {
            if (jumlahTiket > 1) {
                jumlahTiket--
            }
        },
        onPesanTiket = {
            if (namaPembeli.isBlank()) {
                status = "Nama Masih Kosong"
            } else {
                memproses = true
            }
        }
    )

    @Composable
    fun TampilanOrer(
        hargaTiket: Int,
        jumlahTiket: Int,
        namaPembeli: String,
        status: String,
        memproses: Boolean,
        onNamaPembeliChange: () -> Unit,
        onTambahTiket: () -> Int,
        onKurangTiket: () -> Unit,
        onPesanTiket: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    @Composable
    fun TampilanOrder(
        hargaTiket: Int,
        jumlahTiket: Int,
        namaPembeli: String,
        status: String,
        memproses: Boolean,
        onNamaPembeliChange: () -> Unit,
        onTambahTiket: () -> Int,
        onKurangTiket: () -> Unit,
        onPesanTiket: () -> Unit
    ) {
        TODO("Not yet implemented")
    }
}