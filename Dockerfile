# Initialize from the latest PostgreSQL docker image
FROM postgres:latest

# Define environment variables
ENV POSTGRES_PASSWORD=psswd
ENV POSTGRES_HOST_AUTH_METHOD=trust

# Expose the PostgreSQL port from 5432 to 5432
EXPOSE 5432


# Set the default command for the image
CMD ["postgres"]

# End of Dockerfile
#```