package game;

import city.cs.engine.*;

public class PlatformLevel3 extends StaticBody {
    public static final Shape Platform = new BoxShape(6,0.3f);
    public PlatformLevel3(World w) {
        super(w, Platform);
    }
}
