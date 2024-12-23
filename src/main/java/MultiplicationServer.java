import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MultiplicationServer {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        Server server = ServerBuilder.forPort(50052)
                .addService(new MultiplicationService())
                .build();
        System.out.println("Serveur gRPC démarré sur le port 50051...");
        server.start();
        server.awaitTermination();
    }
}
