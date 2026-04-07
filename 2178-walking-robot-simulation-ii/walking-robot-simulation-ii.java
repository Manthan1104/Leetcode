class Robot {
    int w, h, p, pos;
    boolean moved;

    public Robot(int width, int height) {
        w = width;
        h = height;
        p = 2 * (w + h - 2);
        pos = 0;
        moved = false;
    }

    public void step(int num) {
        moved = true;
        pos = (pos + num) % p;
    }

    public int[] getPos() {
        if (pos < w) {
            return new int[]{pos, 0};
        } else if (pos < w + h - 1) {
            return new int[]{w - 1, pos - w + 1};
        } else if (pos < 2 * w + h - 2) {
            return new int[]{2 * w + h - 3 - pos, h - 1};
        } else {
            return new int[]{0, p - pos};
        }
    }

    public String getDir() {
        if (pos == 0) {
            return moved ? "South" : "East";
        } else if (pos < w) {
            return "East";
        } else if (pos < w + h - 1) {
            return "North";
        } else if (pos < 2 * w + h - 2) {
            return "West";
        } else {
            return "South";
        }
    }
}