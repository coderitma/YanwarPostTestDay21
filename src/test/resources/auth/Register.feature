Feature: Register Aplikasi GTPL Bank

   Scenario: Register dengan email valid
      
    Given User sedang berada di halaman register
    When User memasukan email "yanwarsolah@gmail.com"
    And User menekan tombol submit
    Then User akan melihat kredensial yang diberikan
    
   Scenario: Register dengan email tidak valid
      
    Given User sedang berada di halaman register
    When User memasukan email "yanwarsolah.com"
    And User menekan tombol submit
    Then User akan melihat pesan validasi "Email ID is not valid"