# Architecture

This platform uses event-driven microservices for real-time fraud detection.

Main flow:
1. Transaction enters ingestion service
2. Event is published to Kafka
3. Enrichment service adds context
4. Scoring service calculates fraud risk
5. Decision service stores result and creates alerts
6. Dashboard displays suspicious transactions
