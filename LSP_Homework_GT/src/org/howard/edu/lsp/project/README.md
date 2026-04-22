# Event Management System (Cloud Deployment)

## Cloud Platform
Google Cloud Platform (Compute Engine)

## Description
This project is a command-line Event Management System built in Python. It allows users to create accounts, create events, register for events, manage tickets, and view analytics.

## Services Used
- Google Compute Engine (Virtual Machine Instances)
- SSH (remote access)

## How It Works
The system is deployed on a cloud virtual machine. Users interact with the application through a menu-driven interface. The application manages users, events, and tickets using an object-oriented architecture with services, repositories, and managers.

## Features
- User registration
- Event creation and management
- Ticket issuance and cancellation
- Ticket usage (check-in simulation)
- Schedule conflict detection
- Analytics reporting

## How to Run
1. SSH into the VM
2. Run:
   python3 mainv2.py