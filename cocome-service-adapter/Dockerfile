FROM airhacks/payara
ENV ARCHIVE_NAME service-adapter-ear/target/service-adapter-ear-1.1.ear
COPY ./service-adapter-ear/target/service-adapter-ear-1.1.ear ${DEPLOYMENT_DIR}
RUN asadmin start-domain && \
  asadmin create-jdbc-resource --connectionpoolid DerbyPool jdbc/CoCoMEDB && \
  asadmin stop-domain
ENTRYPOINT asadmin start-database && \
    asadmin start-domain --verbose ${DOMAIN_NAME}
