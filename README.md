# JWT Demo Learning

The backend and frontend share one Git repository.

- [backend/](backend/): Spring Boot application, Maven wrapper, tests, and report assets.
- `frontend/`: planned directory for the future frontend application.

Git configuration stays at the repository root and applies to both applications.

## Backend

Read the [backend documentation](backend/repport/README.md) for the authentication
flow, API examples, H2 connection details, and screenshots.

Requires Java 21. Run commands from the backend directory:

```sh
cd backend
./mvnw spring-boot:run
```

Run the backend tests from the same directory:

```sh
./mvnw test
```

The application runs at <http://localhost:8080>. The H2 console is available at
<http://localhost:8080/h2-console/>.

## Frontend

The frontend has not been implemented yet. Its application files will live in
`frontend/`.
