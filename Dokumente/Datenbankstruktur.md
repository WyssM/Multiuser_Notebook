

## Tabelle: `Benutzer`
- `Benutzer_ID` (Primärschlüssel)
- `Benutzername`
- `Passwort`
- `E-Mail`
- `Rolle` (Admin, Benutzer)

## Tabelle: `Notizbuch`
- `Notizbuch_ID` (Primärschlüssel)
- `Titel`
- `Beschreibung`
- `Erstellungsdatum`
- `Ersteller_ID` (Fremdschlüssel aus Benutzer_ID)

## Tabelle: `Kategorien`
- `Kategorie_ID` (Primärschlüssel)
- `Name`
- `Beschreibung`
- `Ersteller_ID` (Fremdschlüssel aus Benutzer_ID)

## Tabelle: `Notizen`
- `Notiz_ID` (Primärschlüssel)
- `Titel`
- `Inhalt`
- `Erstellungsdatum`
- `Letzte_Aktualisierung`
- `Ersteller_ID` (Fremdschlüssel aus Benutzer_ID)
- `Notizbuch_ID` (Fremdschlüssel aus Notizbuch_ID)
- `Kategorie_ID` (Fremdschlüssel aus Kategorie_ID)