package com.zzhoujay.markdown.parser;

/* loaded from: /tmp/classes2.dex */
public class LineQueue {
    private Line curr;
    private Line last;
    private Line root;

    public LineQueue(Line line) {
        this.root = line;
        this.curr = line;
        this.last = line;
        while (this.last.nextLine() != null) {
            this.last = this.last.nextLine();
        }
    }

    private LineQueue(LineQueue lineQueue, Line line) {
        this.root = lineQueue.root;
        this.last = lineQueue.last;
        this.curr = line;
    }

    public void append(Line line) {
        this.last.add(line);
        this.last = line;
    }

    public LineQueue copy() {
        return new LineQueue(this, this.curr);
    }

    public LineQueue copyNext() {
        if (end()) {
            return null;
        }
        return new LineQueue(this, this.curr.nextLine());
    }

    public Line currLine() {
        return this.curr;
    }

    public boolean empty() {
        return this.curr == null || this.root == null || this.last == null;
    }

    public boolean end() {
        return this.curr.nextLine() == null;
    }

    public void insert(Line line) {
        Line line2 = this.curr;
        if (line2 == this.last) {
            append(line);
        } else {
            line2.addNext(line);
        }
    }

    public boolean next() {
        if (this.curr.nextLine() == null) {
            return false;
        }
        this.curr = this.curr.nextLine();
        return true;
    }

    public Line nextLine() {
        return this.curr.nextLine();
    }

    public boolean prev() {
        if (this.curr.prevLine() == null) {
            return false;
        }
        this.curr = currLine().prevLine();
        return true;
    }

    public Line prevLine() {
        return this.curr.prevLine();
    }

    public Line removeCurrLine() {
        Line nextLine;
        Line line = this.curr;
        Line line2 = this.last;
        if (line == line2) {
            nextLine = line2.prevLine();
        } else {
            nextLine = line.nextLine();
            if (this.curr == this.root) {
                this.root = nextLine;
            }
        }
        this.curr.remove();
        Line line3 = this.curr;
        this.curr = nextLine;
        return line3;
    }

    public void removeNextLine() {
        this.curr.removeNext();
    }

    public void removePrevLine() {
        if (this.root == this.curr.prevLine()) {
            this.root = this.curr;
        }
        this.curr.removePrev();
    }

    public void reset() {
        this.curr = this.root;
    }

    public boolean start() {
        return this.curr == this.root;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line = this.root; line != null; line = line.nextLine()) {
            sb.append(line.toString());
            sb.append(",");
        }
        return "{" + sb.toString() + "}";
    }
}
