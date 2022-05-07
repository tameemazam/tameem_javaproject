package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class PlatformLevel4 extends StaticBody {

    public static final Shape Platform = new BoxShape(2,0.3f);
    public PlatformLevel4(World w) {
        super(w, Platform);
    }
}
