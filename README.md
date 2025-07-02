# BIN Lookup Service

A Spring Boot application that loads card BIN ranges from a 3DS PRes JSON file and provides a REST API to retrieve the corresponding 3DS Method URL based on a PAN (Primary Account Number).

---

## How to Run

1. Clone the project or unzip the folder
2. Place the provided `700k-pres.json.data` file inside:

```
src/main/resources/
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

---

## API Endpoint

### POST `/api/bin/lookup`

**Request Body (JSON):**

```json
{
  "pan": "4000020001234567"
}
```

**Response (if match found):**

```json
{
  "startRange": "4000020000000000",
  "endRange": "4000020009999999",
  "threeDSMethodURL": "https://secure4.arcot.com/..."
}
```

**Response (if no match):**

```
404 Not Found
```

## Sample Data File

To test the project, use the provided `700k-pres.json.data` file.

---

## Why the full 700K JSON file is not included

The original data file `700k-pres.json.data` is over 152 MB, which exceeds GitHub’s maximum file size limit of 100 MB.
To keep the repository clean and within GitHub’s constraints, the full file has been excluded from version control and added to `.gitignore`.

To use the full data file:

* Place `700k-pres.json.data` inside `src/main/resources/`
* Restart the application — it will load automatically at startup

---

## Tech Stack
* Java 17
* Spring Boot 3
* Maven
* Jackson (for JSON parsing)
* Lombok

---

## Author
Gansha Kumari
Developed for a backend technical assessment (3DS BIN Lookup)
