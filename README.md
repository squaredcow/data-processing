# gonfluent
Practices and try-outs of Confluent Platform

# Startup and Installation
We use the docker containers to run the Confluent Community stack.
- Kafka 5.2.2
- Zookeeper 5.2.2
- Schema 5.2.2
- Rest Proxy 5.2.2

We have a YAML to be used with docker-compose:
- confluent-stack.yaml

## docker-compose commands

start containers: docker-compose -f confluent-stack.yaml up
stop  containers: docker-compose down
