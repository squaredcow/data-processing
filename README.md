# Data Processing Course

Material to work through the course.

# Prerequisites

Things we need:

- Java 8+
- IntelliJ CE
- Docker CE

# Startup and Installation

We use the docker containers to run the Confluent Community stack.

- Kafka 5.2.2
- Zookeeper 5.2.2
- Schema 5.2.2
- Rest Proxy 5.2.2

We have a YAML to be used with docker-compose:

- confluent-stack.yaml

# Docker Section

## Basic commands

```
# docker
# a self-sufficient runtime for containers

# Some management for docker entities (images. containers, volumes, networks)
docker <entity> ls
docker <entity> inspect <container_id>
docker <entity> prune
docker <entity> rm <container_id>

# Container lifecycle
docker pull <image:version>
docker start <container_id>
docker stop <container_id>
docker logs <container_id>
```

## Compose commands

```
# compose lifecycle
docker-compose -f confluent-stack.yaml up
docker-compose down
```

# Distributed Systems Section

## CAP Theorem

- Data storages resides in this triangle of:
  Consistency, Avaliability and Partition-tolerant

## Distributed Witness

- Magic number

## Sharding

## Replication factors

## Constant Hashing

- MurMur3
- SipHash

## Consensus Algorithms

- Paxos
- Raft

## Architectures for Data Processing

- Lambda Architecture.
- Kappa Architecture.
