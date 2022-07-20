Feature: Add telecom master customer

	Scenario: Menambahkan customer baru data terisi
		Given customer sedang berada di halaman add customer "https://demo.guru99.com/telecom/addcustomer.php"
		When customer memilih "done"
		And customer memasukan nama "Yanwar" dan "Solahudin"
		And customer memasukan email "yanwarsolah@gmail.com"
		And customer memasukan alamat "jl bonapit indo"
		And customer memasukan nomor telepon "0895778094477"
		And customer klik submit dan diproses
		Then customer harus mendapatkan pesan sukses "Access Details to Guru99 Telecom"
	
	Scenario: Menambahkan customer baru data kosong
		Given customer sedang berada di halaman add customer "https://demo.guru99.com/telecom/addcustomer.php"
		And customer fill data "Yanwar" , "Solahudin", "jl bonapit indo" dan "0895778094477"
		And customer klik submit dan diproses
		Then customer harus mendapatkan pesan alert "please fill all fields"
	
