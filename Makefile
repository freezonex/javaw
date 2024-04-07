# Define default target
.PHONY: all server

# Set default target to 'server'
all: server

# Define 'server' target for building Docker image
server:
	docker build --platform=linux/amd64 -t wms-server:1.0.0 .
