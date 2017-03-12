#!/bin/bash

docker run --network=cocome --name registry -d -t registry
docker run --network=cocome --name service-adapter -d -t service-adapter
docker run --network=cocome --name enterprise-logic -d -t enterprise-logic
docker run --network=cocome --name productlist -d -t productlist
docker run --network=cocome --name reporting -d -t reporting
docker run --network=cocome --name stock-order -d -t stock-order
docker run --network=cocome --name user-manager -d -t user-manager
docker run --network=cocome --name store -d -t store
docker run --network=cocome --name cloud-web-frontend -p 8000:8080 -d -t cloud-web-frontend
docker run --network=cocome --name cloud-web-shop -p 8080:8080 -d -t cloud-web-shop
