package pt.ist.anacom.replication.quorumresponse;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import pt.ist.anacom.replication.CommandStrategy;
import pt.ist.anacom.shared.stubs.client.OperatorDetailedType;

public class QuorumOperatorDetailedResponse extends QuorumResponse implements AsyncHandler<OperatorDetailedType> {


    public QuorumOperatorDetailedResponse(String replicaURL, CommandStrategy command) {
        super(replicaURL, command);
    }

    @Override
    public void handleResponse(Response<OperatorDetailedType> res) {

        try {
            OperatorDetailedType replicaResponse = res.get();

            System.out.println(">>>> [LOG]REPLICA VERSION AFTER: " + replicaResponse.getVersion());
            super.getCommand().addResponse(super.getReplicaURL(), replicaResponse);

        } catch (InterruptedException e) {
            System.out.println("Throwing original exception type is " + e.getCause().getClass().getName());
            super.setException(e);
        } catch (ExecutionException e) {
            super.setException(e);
        } finally {
            CommandStrategy.quorumCounter.incrementAndGet();
        }
    }
}
