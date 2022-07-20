Feature: Proses checkout payment e-commerce

	Scenario: Melakukan checkout data transaksi
		Given kustomer ada di halaman "https://demo.guru99.com/payment-gateway/index.php"
		When kustomer memasukan quantity 3
		And kustomer klik tombol pembelian
		And kustomer ada di page "Payment Process"
		And kustomer fill kartu kredit "1111111111111111"
		And kustomer milih month, tahun dan memasukan code "123"
		And kustomer klik tombol bayar
		Then kustomer melihat pesan berhasil "Payment successfull!"