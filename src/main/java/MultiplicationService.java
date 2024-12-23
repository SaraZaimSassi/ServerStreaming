import io.grpc.stub.StreamObserver;
import stub.Fichier;
import stub.MultiplicationGrpc;

public class MultiplicationService extends MultiplicationGrpc.MultiplicationImplBase{
    @Override
    public void getMultiplicationTable(Fichier.MultiplicationRequest request,

                                       StreamObserver<Fichier.MultiplicationResponse> responseObserver) {

        int nombre = request.getNombre();
        int limite = request.getLimite();
        for (int i = 1; i <= limite; i++) {
            String result = nombre + " x " + i + " = " + (nombre * i);
            Fichier.MultiplicationResponse response = Fichier.MultiplicationResponse.newBuilder()
                    .setResultat(result)
                    .build();
// Envoyer le message au client
            responseObserver.onNext(response);
        }
// Terminer le streaming
        responseObserver.onCompleted();
    }
}
