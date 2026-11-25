package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /tmp/classes2.dex */
public final class ir3 extends jc {
    public final Socket a;

    public ir3(Socket socket) {
        socket.getClass();
        this.a = socket;
    }

    @Override // defpackage.jc
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // defpackage.jc
    public void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.a.close();
        } catch (AssertionError e) {
            if (!qs2.e(e)) {
                throw e;
            }
            logger2 = rs2.a;
            logger2.log(Level.WARNING, "Failed to close timed out socket " + this.a, (Throwable) e);
        } catch (Exception e2) {
            logger = rs2.a;
            logger.log(Level.WARNING, "Failed to close timed out socket " + this.a, (Throwable) e2);
        }
    }
}
