# CodeJudge

CodeJudge is a full-stack online judge platform built for coding interviews, algorithm practice, and portfolio demonstrations. It supports problem management, code submission, asynchronous judging, and isolated code execution through a remote sandbox service.

This repository contains three collaborative applications:

- `frontend/codejudge-frontend`: Vue 3 client for question browsing, solving, and administration.
- `backend/codejudge-backend`: Spring Boot API for users, questions, submissions, and judge orchestration.
- `sandbox/codejudge-sandbox`: remote code execution service used by the backend to compile and run user code safely.

## Tech Stack

### Frontend
- Vue 3
- TypeScript
- Vue Router
- Vuex
- Arco Design Vue
- Monaco-based code editor component
- Markdown editor and viewer components

### Backend
- Java 8
- Spring Boot 2.x
- MyBatis-Plus
- MySQL 8
- Redis 7
- Hutool
- Gson and JSON utilities
- Docker Compose

### Sandbox
- Java 8
- Spring Boot
- Process-based code execution
- Docker-friendly deployment
- Request authentication for remote execution calls

## Core Features

- User registration and login
- Question creation, update, and management
- Question browsing with tags and acceptance rate statistics
- Online coding editor with language selection
- Submission history and judge result tracking
- Asynchronous judge pipeline
- Remote sandbox execution service
- Dockerized local environment with MySQL, Redis, backend, and sandbox

## How It Works

1. A user opens a problem and submits source code.
2. The frontend creates a submission record through the backend API.
3. The backend marks the submission as `RUNNING` and loads the test cases for the question.
4. The backend calls the remote sandbox service with the code, language, and test inputs.
5. The sandbox compiles the source code and feeds each test case through standard input.
6. The backend compares the sandbox outputs with the expected outputs and builds the final judge result.
7. The final status, runtime, and message are stored on the submission record.

## Sandbox Concept

The sandbox is the execution boundary between the web platform and untrusted user code.

Instead of running submitted programs directly inside the main backend process, CodeJudge sends execution requests to a dedicated sandbox service. That service is responsible for:

- compiling user code
- executing it with controlled inputs
- measuring runtime
- collecting stdout and stderr
- returning structured execution data to the backend

This separation improves maintainability and makes it easier to evolve toward stricter resource isolation, additional languages, and container-based hardening.

## Why the Project Needs a Sandbox

A normal full-stack web app usually stops at request handling, database access, and API responses. An online judge is different because it must actually process user-submitted programs.

If the main backend compiled and executed submissions directly, it would take on avoidable risk:

- user code could consume excessive CPU or memory
- infinite loops could block backend resources
- temporary source files and compiled artifacts would pollute the application environment
- invoking external toolchains directly inside the business service would reduce stability and observability

By moving compilation and execution into a dedicated sandbox service, the backend stays focused on orchestration, persistence, and result evaluation.

## Why Compilation Also Belongs in the Sandbox

Compilation is not just a harmless preprocessing step. It still means invoking external compilers such as `javac` on untrusted user input, writing temporary files, producing class files or binaries, and consuming system resources.

For that reason, CodeJudge sends both compilation and execution to the sandbox. The sandbox is responsible for:

- creating a temporary workspace for submitted code
- compiling the submission with the correct language toolchain
- executing the compiled program with judge inputs
- collecting stdout, stderr, runtime, and other execution metadata
- returning structured results to the backend judge service

This keeps the core backend cleaner and makes the architecture safer, easier to scale, and easier to extend to more languages in the future.

## Implementation Highlights

- Clear separation between presentation, API, and execution layers
- Remote sandbox architecture instead of direct in-process execution
- Asynchronous judge workflow that decouples submission creation from result generation
- Docker Compose setup for reproducible local development
- Markdown-based problem authoring workflow
- English UI and de-branded project presentation suitable for portfolio use

## Project Structure

```text
CodeJudge/
├─ backend/
│  └─ codejudge-backend/
├─ frontend/
│  └─ codejudge-frontend/
├─ sandbox/
│  └─ codejudge-sandbox/
└─ docker-compose.yml
```

## Running the Project

### Option 1: Docker for backend services

From the project root:

```bash
docker compose up --build -d
```

This starts:

- MySQL on `127.0.0.1:23306`
- Redis on `127.0.0.1:26379`
- Backend on `127.0.0.1:8121`
- Sandbox on `127.0.0.1:8090`

### Option 2: Frontend development server

From `frontend/codejudge-frontend`:

```bash
npm install
npm run serve
```

Then open:

- Frontend: `http://127.0.0.1:8080`

## Notable Engineering Decisions

- The frontend uses a dev proxy so browser requests hit `/api` on the same origin during development.
- The backend wraps sandbox calls through a proxy and factory layer, which makes it easier to switch between sandbox implementations.
- The sandbox uses `stdin` to feed judge cases, which aligns with how real online judges execute user programs.
- Judge failures are written back to the submission record instead of leaving records stuck in a perpetual `RUNNING` state.

## Portfolio Talking Points

- Designed a full-stack online judge platform with a decoupled remote sandbox architecture.
- Built a Dockerized local development environment that reproduces the full judging pipeline.
- Implemented asynchronous code judging and result persistence.
- Added English documentation and de-branded UI to make the project presentation GitHub-ready.


