Feature: Login aplikasi GTPL Bank
	
	Scenario: Login dengan kredensial valid
		Given User sedang berada di halaman login
		When User memasukan userID "mngr425646"
		And User memasukan password "ytahydE"
		And User menekan tombol login dan sistem memprosesnya
		Then User harus berada di halaman "Welcome To Manager's Page of GTPL Bank"
		
	Scenario: Login dengan kredensial tidak valid
		Given User sedang berada di halaman login
		When User memasukan userID "mngr4a4a4a"
		And User memasukan password "mypassword"
		And User menekan tombol login dan sistem memprosesnya
		Then User harus melihat alert berisi "User is not valid"