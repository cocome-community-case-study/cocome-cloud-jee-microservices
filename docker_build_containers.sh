#!/bin/bash
docker build -t cloud-web-shop ./cocome-shop-project
docker build -t productlist ./productlist
docker build -t service-adapter ./cocome-service-adapter
docker build -t reporting ./reporting
docker build -t stock-order ./stock-order
docker build -t user-manager ./user-manager
docker build -t cloud-web-frontend ./cocome-maven-project/cloud-web-frontend
docker build -t enterprise-logic -f ./cocome-maven-project/cloud-logic-service/Dockerfile.enterprise ./cocome-maven-project/cloud-logic-service
docker build -t store -f ./cocome-maven-project/cloud-logic-service/Dockerfile.store ./cocome-maven-project/cloud-logic-service
docker build -t registry -f ./cocome-maven-project/cloud-logic-service/Dockerfile.registry ./cocome-maven-project/cloud-logic-service
