package com.zzhoujay.markdown.parser;

import android.text.SpannableStringBuilder;

/* loaded from: /tmp/classes2.dex */
public class Line {
    public static final int HANDLE_BY_ROOT = 1;
    public static final int LINE_NORMAL = 0;
    public static final int LINE_TYPE_CODE_BLOCK_1 = 11;
    public static final int LINE_TYPE_CODE_BLOCK_2 = 10;
    public static final int LINE_TYPE_GAP = 12;
    public static final int LINE_TYPE_H1 = 4;
    public static final int LINE_TYPE_H2 = 5;
    public static final int LINE_TYPE_H3 = 6;
    public static final int LINE_TYPE_H4 = 7;
    public static final int LINE_TYPE_H5 = 8;
    public static final int LINE_TYPE_H6 = 9;
    public static final int LINE_TYPE_OL = 3;
    public static final int LINE_TYPE_QUOTA = 1;
    public static final int LINE_TYPE_UL = 2;
    private int attr;
    private Line child;
    private int count;
    private int data;
    private int handle;
    private Line next;
    private Line parent;
    private Line prev;
    private String source;
    private CharSequence style;
    private int type;

    private Line(Line line) {
        this.source = line.source;
        this.count = line.count;
        this.attr = line.attr;
        if (line.style != null) {
            this.style = new SpannableStringBuilder(line.style);
        }
        this.type = line.type;
    }

    public Line(String str) {
        this.source = str;
        this.count = 1;
        this.type = 0;
    }

    private void delete() {
        Line line = this.child;
        if (line != null) {
            line.delete();
        }
        Line line2 = this.prev;
        if (line2 != null) {
            line2.next = null;
        }
        this.prev = null;
        Line line3 = this.next;
        if (line3 != null) {
            line3.prev = null;
        }
        this.next = null;
    }

    private void reduce() {
        Line line = this.child;
        if (line != null) {
            line.reduce();
        }
        Line line2 = this.prev;
        if (line2 != null) {
            line2.next = this.next;
        }
        Line line3 = this.next;
        if (line3 != null) {
            line3.prev = line2;
        }
        this.next = null;
        this.prev = null;
    }

    public Line add(Line line) {
        return addNext(line);
    }

    public void addChild(Line line) {
        Line line2 = this.child;
        if (line2 != null) {
            line2.parent = null;
        }
        this.child = line;
        Line line3 = line.parent;
        if (line3 != null) {
            line3.child = null;
        }
        line.parent = this;
        attachChildToNext();
        attachChildToPrev();
    }

    public Line addNext(Line line) {
        if (line == null) {
            this.next = null;
            return line;
        }
        Line line2 = line.next;
        if (line2 != null) {
            line2.prev = null;
        }
        line.next = this.next;
        Line line3 = this.next;
        if (line3 != null) {
            line3.prev = line;
        }
        Line line4 = line.prev;
        if (line4 != null) {
            line4.next = null;
        }
        line.prev = this;
        this.next = line;
        Line line5 = this.child;
        if (line5 != null) {
            line5.addNext(line.child);
        }
        return line;
    }

    public Line addPrev(Line line) {
        if (line == null) {
            this.prev = null;
            return line;
        }
        Line line2 = line.prev;
        if (line2 != null) {
            line2.next = null;
        }
        line.prev = this.prev;
        Line line3 = this.prev;
        if (line3 != null) {
            line3.next = line;
        }
        Line line4 = line.next;
        if (line4 != null) {
            line4.prev = null;
        }
        line.next = this;
        this.prev = line;
        Line line5 = this.child;
        if (line5 != null) {
            line5.addPrev(line.child);
        }
        return line;
    }

    public void attachChildToNext() {
        Line line;
        Line line2 = this.child;
        if (line2 == null || (line = this.next) == null) {
            return;
        }
        Line line3 = line2.next;
        if (line3 != null) {
            line3.prev = null;
        }
        line2.next = line.child;
        Line line4 = this.next.child;
        if (line4 != null) {
            Line line5 = line4.prev;
            if (line5 != null) {
                line5.next = null;
            }
            this.next.child.prev = line2;
        }
        line2.attachChildToNext();
    }

    public void attachChildToPrev() {
        Line line;
        Line line2 = this.child;
        if (line2 == null || (line = this.prev) == null) {
            return;
        }
        Line line3 = line2.prev;
        if (line3 != null) {
            line3.next = null;
        }
        line2.prev = line.child;
        Line line4 = this.prev.child;
        if (line4 != null) {
            Line line5 = line4.next;
            if (line5 != null) {
                line5.prev = null;
            }
            this.prev.child.next = line2;
        }
        line2.attachChildToPrev();
    }

    public void attachToParent(Line line) {
        line.addChild(this);
    }

    public Line childLine() {
        return this.child;
    }

    public Line copyToNext() {
        Line line = this.parent;
        Line copyToNext = line != null ? line.copyToNext() : null;
        Line line2 = new Line(this);
        if (copyToNext != null) {
            copyToNext.addChild(line2);
            return line2;
        }
        line2.next = this.next;
        Line line3 = this.next;
        if (line3 != null) {
            line3.prev = line2;
        }
        line2.prev = this;
        this.next = line2;
        return line2;
    }

    public Line copyToPrev() {
        Line line = this.parent;
        Line copyToPrev = line != null ? line.copyToPrev() : null;
        Line line2 = new Line(this);
        if (copyToPrev != null) {
            copyToPrev.addChild(line2);
            return line2;
        }
        line2.prev = this.prev;
        Line line3 = this.prev;
        if (line3 != null) {
            line3.next = line2;
        }
        line2.next = this;
        this.prev = this;
        return line2;
    }

    public Line createChild(String str) {
        Line line = new Line(str);
        addChild(line);
        return line;
    }

    public Line get() {
        return this;
    }

    public int getAttr() {
        return this.attr;
    }

    public int getCount() {
        return this.count;
    }

    public int getData() {
        return this.data;
    }

    public int getHandle() {
        return this.handle;
    }

    public String getSource() {
        return this.source;
    }

    public CharSequence getStyle() {
        return this.style;
    }

    public int getType() {
        return this.type;
    }

    public Line nextLine() {
        return this.next;
    }

    public Line parentLine() {
        return this.parent;
    }

    public Line prevLine() {
        return this.prev;
    }

    public void remove() {
        if (this.parent == null) {
            reduce();
        } else {
            delete();
        }
    }

    public Line removeNext() {
        Line line = this.next;
        if (line != null) {
            line.remove();
        }
        return this;
    }

    public Line removePrev() {
        Line line = this.prev;
        if (line != null) {
            line.remove();
        }
        return this;
    }

    public void setAttr(int i) {
        this.attr = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setData(int i) {
        this.data = i;
    }

    public void setHandle(int i) {
        this.handle = i;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStyle(CharSequence charSequence) {
        this.style = charSequence;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return this.source;
    }

    public void unAttachFromParent() {
        if (this.parent != null) {
            delete();
            this.parent.child = null;
        }
        this.parent = null;
    }
}
