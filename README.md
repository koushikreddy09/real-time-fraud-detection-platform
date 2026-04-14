# Real-Time Fraud Detection Platform

An event-driven credit card fraud detection platform built with Spring Boot, Kafka, Redis, PostgreSQL, and React.

## Overview

This project simulates a real-world payment fraud detection pipeline using distributed services.

It is designed to:
- ingest credit card transactions in real time
- enrich them with behavioral and historical context
- calculate a fraud risk score
- classify transactions into approve, review, or block flows
- surface suspicious transactions in an analyst dashboard

## Planned Architecture

- transaction-ingestion-service
- feature-enrichment-service
- fraud-scoring-service
- decision-alert-service
- analyst-dashboard
- Kafka
- Redis
- PostgreSQL

## Tech Stack

- Java 17
- Spring Boot
- Kafka
- Redis
- PostgreSQL
- React
- Docker Compose

## Status

Project setup in progress.
