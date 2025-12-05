# Futóverseny Kezelő Alkalmazás

Egyszerű Spring Boot webalkalmazás, amely futóversenyek résztvevőit és eredményeit kezeli.

## Funkciók

- Futók nyilvántartása (név, életkor, nem)
- Versenyek nyilvántartása (név, táv km-ben)
- Eredmények rögzítése (futó, verseny, idő percben)
- Átlagos futási idő kiszámítása versenyenként
- Thymeleaf alapú frontend:
  - Versenyek listázása (`/races`)
  - Új verseny létrehozása
  - Verseny részletek + eredmények megjelenítése

## REST API végpontok

- `GET  /getRunners` – összes futó alapadatai
- `POST /addRunner` – új futó felvétele
- `GET  /getRaceRunners/{id}` – adott verseny futói idő szerint rendezve
- `POST /updateRace` – verseny nevének és távjának módosítása
- `POST /addResult` – új eredmény rögzítése
- `GET  /getAverageTime/{id}` – adott verseny átlagos futási ideje

## Technológia

- Spring Boot, Spring Web, Spring Data JPA
- H2 in-memory adatbázis
- Thymeleaf template-ek
- Bean Validation (`jakarta.validation`) + globális hibakezelés
- Postman collection a `src/test/resources/api-tests` mappában

## Futtatás

```bash
mvnw spring-boot:run
