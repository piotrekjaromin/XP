# Coding rules
1. Język programowania: Java 8
2. Wszystko po angielsku: komentarze, zmienne, klasy, metody itp
3. Styl formatowania: domyślny intellij idea
4. Zdalne repozytorium: github
5. System kontroli wercji: Git
6. Nazwy pakietów według funkcjonalności
7. Pakiety dla testów jednostowych takie same jak dla klas
8. Nazwy testów takie same jak nazwy klas z sufiksem: "Test"
9. Środowisko do testów akceptacyjnych: FitNesse
10. IDE: Intellij Idea

# Unit Test Coverage
- w /coverage/index.html znajdują się raporty Cobertura z przeprowadzonych testów


# FitNesse Acceptance Tests how to
1. Zbuduj projekt - mvn clean install
2. Uruchom FitNesse - mvn mafia:start
3. W przeglądarce wpisz localhost:9090
4. Przejdź do wybranej strony i uruchom test
5. Po zakończonych testach - mvn mafia:stop

W resources znajdują się dodatkowe informacje na temat testów akceptacyjnych.
