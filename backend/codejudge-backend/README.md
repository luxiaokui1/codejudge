# CodeJudge Backend

This module provides the Spring Boot backend for CodeJudge.

## Responsibilities

- user authentication and session management
- question CRUD and query APIs
- submission creation and history APIs
- judge orchestration through the remote sandbox
- persistence with MySQL and Redis

## Key Packages

- `com.codejudge.platform.controller`
- `com.codejudge.platform.service`
- `com.codejudge.platform.judge`
- `com.codejudge.platform.model`

## Local Run

Use the project root Docker Compose file to start the backend with MySQL, Redis, and the sandbox.
