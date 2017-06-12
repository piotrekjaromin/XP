Po uruchomieniu FitNesse na localhost:9090 powienniście mieć stronke główną - FrontPage.
Każda następna strona jest jej podstroną i idzie się do niej wpisując FrontPage.NazwaPodstrony
w URL. Ja stworzyłam jedną stronę (CompaniesTest) ale raczej jest ona dostępna lokalnie - jak wpisując
http://localhost:9090/FrontPage.CompaniesTest nic Wam się nie wyświetli to trzeba zrobić od nowa.
W katalogu scripts wrzuciłam konfiguracje dla tej strony. Jak się wyświetli coś to klikacie 'Test' i już :)

Żeby stworzyć strone i odpalić testy trzeba:
- na głównej stronie wybrać 'Add -> Test Page' w prawym górnym rogu
- potem wpisać Page Name jaką się chce np. CompaniesTest
- w tym dużym polu wpisać skrypt testowy (jest w /scripts) - tylko każdy musi sobie ustawić
  ścieżkę do /target/classes swoją!
- dać save
- potem w na tej nowej stronie dać 'Test' w prawym górnym rogu
- the end <3

