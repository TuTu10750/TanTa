package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;

/* loaded from: /tmp/classes2.dex */
public final class tb3 implements yp2 {
    public final ConnectivityManager a;
    public final yp2$a b;
    public final a c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            tb3.this.d(network, true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            tb3.this.d(network, false);
        }
    }

    public tb3(ConnectivityManager connectivityManager, yp2$a yp2_a) {
        this.a = connectivityManager;
        this.b = yp2_a;
        a aVar = new a();
        this.c = aVar;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar);
    }

    public boolean a() {
        Network[] allNetworks = this.a.getAllNetworks();
        int length = allNetworks.length;
        int i = 0;
        while (i < length) {
            Network network = allNetworks[i];
            i++;
            if (c(network)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.a.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    public final void d(Network network, boolean z) {
        Network[] allNetworks = this.a.getAllNetworks();
        int length = allNetworks.length;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Network network2 = allNetworks[i];
            i++;
            if (dq1.a(network2, network) ? z : c(network2)) {
                z2 = true;
                break;
            }
        }
        this.b.a(z2);
    }

    public void shutdown() {
        this.a.unregisterNetworkCallback(this.c);
    }
}
