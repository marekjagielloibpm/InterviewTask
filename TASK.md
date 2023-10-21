# Zadanie:

### 1. Przegląd kodu i znajdowanie błędów
* Znajdź błędy w kodzie i wytłumacz ich konsekwencje
* Znajdź możliwości użycia wzorców projektowych

### 2. Nowa funkcjonalność
Klient chce, aby w aplikacji pojawiła się nowa funkcjonalność. 
System nie powinien pozwolić na zaplanowanie nowej instalacji jeśli w tym samym adresie jest już zaplanowane więcej instalacji w statusie SCHEDULED niż wynosi limit (ProductEntity.installationLimit)
w przypadku gdy limit jest przekroczony, system powinien zwrócić wartość NULL.

### 3. Uruchom testy

### 4. Zaprojektuj REST API w InstallationController dla usług w serwisie InstallationService 