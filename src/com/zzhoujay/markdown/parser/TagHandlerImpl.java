package com.zzhoujay.markdown.parser;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import android.util.SparseArray;
import com.zzhoujay.markdown.parser.QueueConsumer;
import com.zzhoujay.markdown.style.CodeSpan;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/classes2.dex */
public class TagHandlerImpl implements TagHandler {
    private static final Matcher matcherAutoLink;
    private static final Matcher matcherBlankLine;
    private static final Matcher matcherCode;
    private static final Matcher matcherCodeBlock;
    private static final Matcher matcherCodeBlock2;
    private static final Matcher matcherDelete;
    private static final Matcher matcherEm;
    private static final Matcher matcherEmItalic;
    private static final Matcher matcherEmail;
    private static final Matcher matcherEndSpace;
    private static final Matcher matcherGap;
    private static final Matcher matcherH;
    private static final Matcher matcherH1;
    private static final Matcher matcherH1_2;
    private static final Matcher matcherH2;
    private static final Matcher matcherH2_2;
    private static final Matcher matcherH3;
    private static final Matcher matcherH4;
    private static final Matcher matcherH5;
    private static final Matcher matcherH6;
    private static final Matcher matcherImage;
    private static final Matcher matcherImage2;
    private static final Matcher matcherImageId;
    private static final Matcher matcherInlineSpace;
    private static final Matcher matcherItalic;
    private static final Matcher matcherLink;
    private static final Matcher matcherLink2;
    private static final Matcher matcherLinkId;
    private static final Matcher matcherOl;
    private static final Matcher matcherQuota;
    private static final Matcher matcherUl;
    private static final SparseArray<Matcher> matchers;
    private HashMap<String, Pair<String, String>> idImageUrl = new HashMap<>();
    private HashMap<String, Pair<String, String>> idLinkLinks = new HashMap<>();
    private QueueConsumer.QueueProvider queueProvider;
    private StyleBuilder styleBuilder;

    static {
        Matcher matcher = Pattern.compile("^\\s*=+\\s*$").matcher("");
        matcherH1_2 = matcher;
        Matcher matcher2 = Pattern.compile("^\\s*-+\\s*$").matcher("");
        matcherH2_2 = matcher2;
        Matcher matcher3 = Pattern.compile("^\\s*#{1,6}\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH = matcher3;
        Matcher matcher4 = Pattern.compile("^\\s*#\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH1 = matcher4;
        Matcher matcher5 = Pattern.compile("^\\s*#{2}\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH2 = matcher5;
        Matcher matcher6 = Pattern.compile("^\\s*#{3}\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH3 = matcher6;
        Matcher matcher7 = Pattern.compile("^\\s*#{4}\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH4 = matcher7;
        Matcher matcher8 = Pattern.compile("^\\s*#{5}\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH5 = matcher8;
        Matcher matcher9 = Pattern.compile("^\\s*#{6}\\s*([^#]*)(\\s*#)?").matcher("");
        matcherH6 = matcher9;
        Matcher matcher10 = Pattern.compile("^\\s{0,3}>\\s(.*)").matcher("");
        matcherQuota = matcher10;
        Matcher matcher11 = Pattern.compile("^\\s*[*+-]\\s+(.*)").matcher("");
        matcherUl = matcher11;
        Matcher matcher12 = Pattern.compile("^\\s*\\d+\\.\\s+(.*)").matcher("");
        matcherOl = matcher12;
        Matcher matcher13 = Pattern.compile("[^*_]*(([*_])([^*_].*?)\\2)").matcher("");
        matcherItalic = matcher13;
        Matcher matcher14 = Pattern.compile("[^*_]*(([*_])\\2([^*_].*?)\\2\\2)").matcher("");
        matcherEm = matcher14;
        Matcher matcher15 = Pattern.compile("[^*_]*(([*_])\\2\\2([^*_].*?)\\2\\2\\2)").matcher("");
        matcherEmItalic = matcher15;
        Matcher matcher16 = Pattern.compile("[^~]*((~{2,4})([^~].*?)\\2)").matcher("");
        matcherDelete = matcher16;
        Matcher matcher17 = Pattern.compile("[^`]*((`+)([^`].*?)\\2)").matcher("");
        matcherCode = matcher17;
        Matcher matcher18 = Pattern.compile(".*?(\\[\\s*(.*?)\\s*]\\(\\s*(\\S*?)(\\s+(['\"])(.*?)\\5)?\\s*?\\))").matcher("");
        matcherLink = matcher18;
        Matcher matcher19 = Pattern.compile(".*?(!\\[\\s*(.*?)\\s*]\\(\\s*(\\S*?)(\\s+(['\"])(.*?)\\5)?\\s*?\\))").matcher("");
        matcherImage = matcher19;
        Matcher matcher20 = Pattern.compile(".*?(\\[\\s*(.*?)\\s*]\\s*\\[\\s*(.*?)\\s*])").matcher("");
        matcherLink2 = matcher20;
        Matcher matcher21 = Pattern.compile("^\\s*\\[\\s*(.*?)\\s*]:\\s*(\\S+?)(\\s+(['\"])(.*?)\\4)?\\s*$").matcher("");
        matcherLinkId = matcher21;
        Matcher matcher22 = Pattern.compile(".*?(!\\[\\s*(.*?)\\s*]\\s*\\[\\s*(.*?)\\s*])").matcher("");
        matcherImage2 = matcher22;
        Matcher matcher23 = Pattern.compile("^\\s*!\\[\\s*(.*?)\\s*]:\\s*(\\S+?)(\\s+(['\"])(.*?)\\4)?\\s*$").matcher("");
        matcherImageId = matcher23;
        Matcher matcher24 = Pattern.compile(".*?(<(\\S+@\\S+\\.\\S+)>).*?").matcher("");
        matcherEmail = matcher24;
        Matcher matcher25 = Pattern.compile("((https|http|ftp|rtsp|mms)?://)[^\\s]+").matcher("");
        matcherAutoLink = matcher25;
        Matcher matcher26 = Pattern.compile("(.*?) {2} *$").matcher("");
        matcherEndSpace = matcher26;
        matcherInlineSpace = Pattern.compile("\\S*(\\s+)\\S+").matcher("");
        Matcher matcher27 = Pattern.compile("^( {4}|\\t)(.*)").matcher("");
        matcherCodeBlock = matcher27;
        Matcher matcher28 = Pattern.compile("^\\s*```").matcher("");
        matcherCodeBlock2 = matcher28;
        Matcher matcher29 = Pattern.compile("^\\s*$").matcher("");
        matcherBlankLine = matcher29;
        Matcher matcher30 = Pattern.compile("^\\s*([-*]\\s*){3,}$").matcher("");
        matcherGap = matcher30;
        SparseArray<Matcher> sparseArray = new SparseArray<>();
        matchers = sparseArray;
        sparseArray.put(1, matcher27);
        sparseArray.put(2, matcher28);
        sparseArray.put(3, matcher4);
        sparseArray.put(4, matcher5);
        sparseArray.put(24, matcher6);
        sparseArray.put(5, matcher7);
        sparseArray.put(6, matcher8);
        sparseArray.put(7, matcher9);
        sparseArray.put(23, matcher3);
        sparseArray.put(8, matcher10);
        sparseArray.put(9, matcher11);
        sparseArray.put(10, matcher12);
        sparseArray.put(11, matcher14);
        sparseArray.put(12, matcher13);
        sparseArray.put(13, matcher15);
        sparseArray.put(14, matcher24);
        sparseArray.put(15, matcher25);
        sparseArray.put(16, matcher16);
        sparseArray.put(17, matcher18);
        sparseArray.put(18, matcher20);
        sparseArray.put(19, matcher21);
        sparseArray.put(20, matcher19);
        sparseArray.put(21, matcher22);
        sparseArray.put(22, matcher23);
        sparseArray.put(25, matcher29);
        sparseArray.put(26, matcher26);
        sparseArray.put(27, matcher30);
        sparseArray.put(28, matcher);
        sparseArray.put(29, matcher2);
        sparseArray.put(30, matcher17);
    }

    public TagHandlerImpl(StyleBuilder styleBuilder) {
        this.styleBuilder = styleBuilder;
    }

    private boolean checkInCode(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        for (CodeSpan codeSpan : (CodeSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), CodeSpan.class)) {
            int spanStart = spannableStringBuilder.getSpanStart(codeSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(codeSpan);
            if (spanStart < i2 && spanEnd > i) {
                return true;
            }
        }
        return false;
    }

    private Matcher obtain(int i, CharSequence charSequence) {
        Matcher matcher = matchers.get(i, null);
        if (matcher != null) {
            matcher.reset(charSequence);
        }
        return matcher;
    }

    private boolean ol(Line line, int i) {
        Matcher obtain = obtain(10, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(3);
        Line line2 = new Line(obtain.group(1));
        line.setAttr(0);
        Line parentLine = line.parentLine();
        LineQueue queue = this.queueProvider.getQueue();
        Line prevLine = line.prevLine();
        boolean z = queue.currLine().getType() == 1;
        if (z) {
            line.setHandle(1);
            line.setData(3);
        }
        if (prevLine != null && (prevLine.getType() == 3 || prevLine.getType() == 2)) {
            if (i > 0) {
                line.setAttr(i);
            } else {
                String replaceAll = line.getSource().substring(obtain.start(), obtain.start(1) - 2).replaceAll("\\t", "    ");
                if (replaceAll.length() > (prevLine.getAttr() * 2) + 1) {
                    line.setAttr(prevLine.getAttr() + 1);
                } else {
                    line.setAttr(replaceAll.length() / 2);
                }
            }
        }
        if (prevLine != null && prevLine.getType() == 3 && prevLine.getAttr() == line.getAttr()) {
            line.setCount(prevLine.getCount() + 1);
        } else {
            line.setCount(1);
        }
        if (z) {
            line.setStyle(" ");
        } else {
            line.setStyle(this.styleBuilder.ol(" ", line.getAttr(), line.getCount()));
        }
        if (find(9, line2)) {
            int attr = line.getAttr() + 1;
            line2.unAttachFromParent();
            if (parentLine != null) {
                Line copyToNext = parentLine.copyToNext();
                copyToNext.addChild(line2);
                queue.next();
                ul(line2, attr);
                if (z) {
                    while (copyToNext.parentLine() != null) {
                        copyToNext = copyToNext.parentLine();
                    }
                    copyToNext.setStyle(this.styleBuilder.ul2(line2.getStyle(), findCount(8, copyToNext, 1) - 1, line2.getAttr()));
                } else {
                    while (copyToNext != null && copyToNext.getType() == 1) {
                        copyToNext.setStyle(this.styleBuilder.quota(line2.getStyle()));
                        copyToNext = copyToNext.parentLine();
                    }
                }
            } else {
                line.addNext(line2);
                queue.next();
                ul(queue.currLine(), attr);
            }
            return true;
        }
        if (!find(10, line2)) {
            CharSequence style = h(line2) ? line2.getStyle() : line2.getSource();
            line.setStyle(style instanceof SpannableStringBuilder ? (SpannableStringBuilder) style : new SpannableStringBuilder(style));
            inline(line);
            if (!z) {
                line.setStyle(this.styleBuilder.ol(line.getStyle(), line.getAttr(), line.getCount()));
            }
            return true;
        }
        int attr2 = line.getAttr() + 1;
        line2.unAttachFromParent();
        if (parentLine != null) {
            Line copyToNext2 = parentLine.copyToNext();
            copyToNext2.addChild(line2);
            queue.next();
            ol(line2, attr2);
            if (z) {
                while (copyToNext2.parentLine() != null) {
                    copyToNext2 = copyToNext2.parentLine();
                }
                copyToNext2.setStyle(this.styleBuilder.ol2(line2.getStyle(), findCount(8, copyToNext2, 1) - 1, line2.getAttr(), line2.getCount()));
            } else {
                while (copyToNext2 != null && copyToNext2.getType() == 1) {
                    copyToNext2.setStyle(this.styleBuilder.quota(line2.getStyle()));
                    copyToNext2 = copyToNext2.parentLine();
                }
            }
        } else {
            line.addNext(line2);
            queue.next();
            ol(queue.currLine(), attr2);
        }
        return true;
    }

    private void removeNextBlankLine(LineQueue lineQueue) {
        while (lineQueue.nextLine() != null && find(25, lineQueue.nextLine())) {
            lineQueue.removeNextLine();
        }
    }

    private void removePrevBlankLine(LineQueue lineQueue) {
        while (lineQueue.prevLine() != null && find(25, lineQueue.prevLine())) {
            lineQueue.removePrevLine();
        }
    }

    private boolean ul(Line line, int i) {
        Matcher obtain = obtain(9, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(2);
        Line createChild = line.createChild(obtain.group(1));
        line.setAttr(0);
        Line parentLine = line.parentLine();
        LineQueue queue = this.queueProvider.getQueue();
        Line prevLine = line.prevLine();
        boolean z = queue.currLine().getType() == 1;
        if (z) {
            line.setHandle(1);
            line.setData(2);
        }
        if (prevLine != null && (prevLine.getType() == 3 || prevLine.getType() == 2)) {
            if (i > 0) {
                line.setAttr(i);
            } else {
                String replaceAll = line.getSource().substring(obtain.start(), obtain.start(1) - 2).replaceAll("\\t", "    ");
                if (replaceAll.length() > (prevLine.getAttr() * 2) + 1) {
                    line.setAttr(prevLine.getAttr() + 1);
                } else {
                    line.setAttr(replaceAll.length() / 2);
                }
            }
        }
        if (z) {
            line.setStyle(" ");
        } else {
            line.setStyle(this.styleBuilder.ul(" ", line.getAttr()));
        }
        if (find(9, createChild)) {
            int attr = line.getAttr() + 1;
            createChild.unAttachFromParent();
            if (parentLine != null) {
                Line copyToNext = parentLine.copyToNext();
                copyToNext.addChild(createChild);
                queue.next();
                ul(createChild, attr);
                if (z) {
                    while (copyToNext.parentLine() != null) {
                        copyToNext = copyToNext.parentLine();
                    }
                    copyToNext.setStyle(this.styleBuilder.ul2(createChild.getStyle(), findCount(8, copyToNext, 1) - 1, createChild.getAttr()));
                } else {
                    while (copyToNext != null && copyToNext.getType() == 1) {
                        copyToNext.setStyle(this.styleBuilder.quota(createChild.getStyle()));
                        copyToNext = copyToNext.parentLine();
                    }
                }
            } else {
                line.addNext(createChild);
                queue.next();
                ul(queue.currLine(), attr);
            }
            return true;
        }
        if (!find(10, createChild)) {
            CharSequence style = h(createChild) ? createChild.getStyle() : createChild.getSource();
            line.setStyle(style instanceof SpannableStringBuilder ? (SpannableStringBuilder) style : new SpannableStringBuilder(style));
            inline(line);
            if (!z) {
                line.setStyle(this.styleBuilder.ul(line.getStyle(), line.getAttr()));
            }
            return true;
        }
        int attr2 = line.getAttr() + 1;
        createChild.unAttachFromParent();
        if (parentLine != null) {
            Line copyToNext2 = parentLine.copyToNext();
            copyToNext2.addChild(createChild);
            queue.next();
            ol(createChild, attr2);
            if (z) {
                while (copyToNext2.parentLine() != null) {
                    copyToNext2 = copyToNext2.parentLine();
                }
                copyToNext2.setStyle(this.styleBuilder.ol2(createChild.getStyle(), findCount(8, copyToNext2, 1) - 1, createChild.getAttr(), createChild.getCount()));
            } else {
                while (copyToNext2 != null && copyToNext2.getType() == 1) {
                    copyToNext2.setStyle(this.styleBuilder.quota(createChild.getStyle()));
                    copyToNext2 = copyToNext2.parentLine();
                }
            }
        } else {
            line.addNext(createChild);
            queue.next();
            ol(queue.currLine(), attr2);
        }
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean autoLink(Line line) {
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line.get().getStyle();
        Matcher obtain = obtain(15, spannableStringBuilder);
        boolean z = false;
        while (obtain.find()) {
            String group = obtain.group();
            spannableStringBuilder.delete(obtain.start(), obtain.end());
            spannableStringBuilder.insert(obtain.start(), (CharSequence) this.styleBuilder.link(group, group, ""));
            z = true;
        }
        return z;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean code(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(30, spannableStringBuilder);
        if (!obtain.find()) {
            return false;
        }
        String group = obtain.group(3);
        spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
        spannableStringBuilder.insert(obtain.start(1), (CharSequence) this.styleBuilder.code(group));
        code(line2);
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean codeBlock1(Line line) {
        Matcher obtain = obtain(1, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        String group = obtain.group(2);
        LineQueue queue = this.queueProvider.getQueue();
        StringBuilder sb = new StringBuilder(group);
        StringBuilder sb2 = new StringBuilder();
        for (Line nextLine = queue.nextLine(); nextLine != null; nextLine = queue.nextLine()) {
            CharSequence charSequence = get(1, nextLine, 2);
            if (charSequence == null) {
                if (!find(25, nextLine)) {
                    break;
                }
                sb2.append(' ');
                sb2.append('\n');
            } else if (sb2.length() != 0) {
                sb.append((CharSequence) sb2);
                sb.append(charSequence);
                sb2.delete(0, sb.length());
            } else {
                sb.append('\n');
                sb.append(charSequence);
            }
            queue.removeNextLine();
        }
        line.setType(11);
        line.setStyle(this.styleBuilder.codeBlock(sb.toString()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean codeBlock2(Line line) {
        if (find(2, line)) {
            LineQueue queue = this.queueProvider.getQueue();
            LineQueue copy = queue.copy();
            while (copy.nextLine() != null) {
                if (find(2, copy.nextLine())) {
                    copy.next();
                    removePrevBlankLine(copy);
                    removeNextBlankLine(queue);
                    StringBuilder sb = new StringBuilder();
                    queue.next();
                    queue.removePrevLine();
                    while (queue.currLine() != copy.currLine()) {
                        sb.append(queue.currLine().getSource());
                        sb.append('\n');
                        queue.next();
                        queue.removePrevLine();
                    }
                    removeNextBlankLine(copy);
                    copy.currLine().setType(10);
                    copy.currLine().setStyle(this.styleBuilder.codeBlock(sb.toString()));
                    return true;
                }
                copy.next();
            }
        }
        return false;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean delete(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(16, spannableStringBuilder);
        while (obtain.find()) {
            if (!checkInCode(spannableStringBuilder, obtain.start(1), obtain.end(1))) {
                SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(obtain.start(3), obtain.end(3));
                spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
                spannableStringBuilder.insert(obtain.start(1), this.styleBuilder.delete(spannableStringBuilder2));
                delete(line2);
                return true;
            }
        }
        return false;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean em(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(11, spannableStringBuilder);
        while (obtain.find()) {
            if (!checkInCode(spannableStringBuilder, obtain.start(1), obtain.end(1))) {
                SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(obtain.start(3), obtain.end(3));
                spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
                spannableStringBuilder.insert(obtain.start(1), this.styleBuilder.em(spannableStringBuilder2));
                em(line2);
                return true;
            }
        }
        return false;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean emItalic(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(13, spannableStringBuilder);
        while (obtain.find()) {
            if (!checkInCode(spannableStringBuilder, obtain.start(1), obtain.end(1))) {
                SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(obtain.start(3), obtain.end(3));
                spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
                spannableStringBuilder.insert(obtain.start(1), this.styleBuilder.emItalic(spannableStringBuilder2));
                emItalic(line2);
                return true;
            }
        }
        return false;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean email(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(14, spannableStringBuilder);
        if (!obtain.find()) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(obtain.start(2), obtain.end(2));
        spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
        spannableStringBuilder.insert(obtain.start(1), (CharSequence) this.styleBuilder.email(spannableStringBuilder2));
        email(line2);
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagFinder
    public boolean find(int i, Line line) {
        return line != null && find(i, line.getSource());
    }

    @Override // com.zzhoujay.markdown.parser.TagFinder
    public boolean find(int i, String str) {
        Matcher obtain;
        return (str == null || (obtain = obtain(i, str)) == null || !obtain.find()) ? false : true;
    }

    @Override // com.zzhoujay.markdown.parser.TagFinder
    public int findCount(int i, Line line, int i2) {
        if (line == null) {
            return 0;
        }
        return findCount(i, line.getSource(), i2);
    }

    @Override // com.zzhoujay.markdown.parser.TagFinder
    public int findCount(int i, String str, int i2) {
        Matcher obtain;
        if (str == null || (obtain = obtain(i, str)) == null || !obtain.find()) {
            return 0;
        }
        return findCount(i, obtain.group(i2), i2) + 1;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean gap(Line line) {
        Line line2 = line.get();
        if (!obtain(27, line2.getSource()).matches()) {
            return false;
        }
        line2.setType(12);
        line2.setStyle(this.styleBuilder.gap());
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagGetter
    public CharSequence get(int i, Line line, int i2) {
        return get(i, line.getSource(), i2);
    }

    @Override // com.zzhoujay.markdown.parser.TagGetter
    public CharSequence get(int i, CharSequence charSequence, int i2) {
        Matcher obtain = obtain(i, charSequence);
        if (obtain.find()) {
            return obtain.group(i2);
        }
        return null;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h(Line line) {
        return h6(line) || h5(line) || h4(line) || h3(line) || h2(line) || h1(line);
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h1(Line line) {
        Matcher obtain = obtain(3, line.getSource());
        if (obtain == null || !obtain.find()) {
            return false;
        }
        line.setType(4);
        line.setStyle(SpannableStringBuilder.valueOf(obtain.group(1)));
        inline(line);
        line.setStyle(this.styleBuilder.h1(line.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h2(Line line) {
        Matcher obtain = obtain(4, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(5);
        line.setStyle(SpannableStringBuilder.valueOf(obtain.group(1)));
        inline(line);
        line.setStyle(this.styleBuilder.h2(line.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h3(Line line) {
        Matcher obtain = obtain(24, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(6);
        line.setStyle(SpannableStringBuilder.valueOf(obtain.group(1)));
        inline(line);
        line.setStyle(this.styleBuilder.h3(line.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h4(Line line) {
        Matcher obtain = obtain(5, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(7);
        line.setStyle(SpannableStringBuilder.valueOf(obtain.group(1)));
        inline(line);
        line.setStyle(this.styleBuilder.h4(line.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h5(Line line) {
        Matcher obtain = obtain(6, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(8);
        line.setStyle(SpannableStringBuilder.valueOf(obtain.group(1)));
        inline(line);
        line.setStyle(this.styleBuilder.h5(line.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean h6(Line line) {
        Matcher obtain = obtain(7, line.getSource());
        if (!obtain.find()) {
            return false;
        }
        line.setType(9);
        line.setStyle(SpannableStringBuilder.valueOf(obtain.group(1)));
        inline(line);
        line.setStyle(this.styleBuilder.h6(line.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean image(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(20, spannableStringBuilder);
        if (!obtain.find()) {
            return false;
        }
        String group = obtain.group(2);
        String group2 = obtain.group(3);
        String group3 = obtain.group(6);
        spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
        spannableStringBuilder.insert(obtain.start(1), (CharSequence) this.styleBuilder.image(group, group2, group3));
        image(line2);
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean image2(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(21, spannableStringBuilder);
        if (!obtain.find()) {
            return false;
        }
        String group = obtain.group(2);
        Pair<String, String> pair = this.idImageUrl.get(obtain.group(3));
        if (pair == null) {
            return false;
        }
        spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
        spannableStringBuilder.insert(obtain.start(1), (CharSequence) this.styleBuilder.image(group, (String) pair.first, (String) pair.second));
        image2(line2);
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean imageId(String str) {
        Matcher obtain = obtain(22, str);
        if (!obtain.find()) {
            return false;
        }
        this.idImageUrl.put(obtain.group(1), new Pair<>(obtain.group(2), obtain.group(5)));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean inline(Line line) {
        return autoLink(line) || (link2(line) || (link(line) || (image2(line) || (image(line) || (email(line) || (delete(line) || (italic(line) || (em(line) || (emItalic(line) || code(line))))))))));
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean italic(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(12, spannableStringBuilder);
        while (obtain.find()) {
            if (!checkInCode(spannableStringBuilder, obtain.start(1), obtain.end(1))) {
                SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(obtain.start(3), obtain.end(3));
                spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
                spannableStringBuilder.insert(obtain.start(1), this.styleBuilder.italic(spannableStringBuilder2));
                italic(line2);
                return true;
            }
        }
        return false;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean link(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(17, spannableStringBuilder);
        if (!obtain.find()) {
            return false;
        }
        String group = obtain.group(2);
        String group2 = obtain.group(3);
        String group3 = obtain.group(6);
        spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
        spannableStringBuilder.insert(obtain.start(1), (CharSequence) this.styleBuilder.link(group, group2, group3));
        link(line2);
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean link2(Line line) {
        Line line2 = line.get();
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) line2.getStyle();
        Matcher obtain = obtain(18, spannableStringBuilder);
        if (!obtain.find()) {
            return false;
        }
        String group = obtain.group(2);
        Pair<String, String> pair = this.idLinkLinks.get(obtain.group(3));
        if (pair == null) {
            return false;
        }
        spannableStringBuilder.delete(obtain.start(1), obtain.end(1));
        spannableStringBuilder.insert(obtain.start(1), (CharSequence) this.styleBuilder.link(group, (String) pair.first, (String) pair.second));
        link2(line2);
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean linkId(String str) {
        Matcher obtain = obtain(19, str);
        if (!obtain.find()) {
            return false;
        }
        this.idLinkLinks.put(obtain.group(1), new Pair<>(obtain.group(2), obtain.group(5)));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean ol(Line line) {
        return ol(line, 0);
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean quota(Line line) {
        LineQueue queue = this.queueProvider.getQueue();
        Line line2 = line.get();
        Matcher obtain = obtain(8, line2.getSource());
        if (!obtain.find()) {
            return false;
        }
        line2.setType(1);
        Line createChild = line2.createChild(obtain.group(1));
        line2.attachChildToNext();
        line2.attachChildToPrev();
        Line prevLine = queue.prevLine();
        if (line2.parentLine() == null && prevLine != null && prevLine.getType() == 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            this.styleBuilder.quota(spannableStringBuilder);
            while (prevLine.childLine() != null && prevLine.childLine().getType() == 1) {
                prevLine = prevLine.childLine();
                this.styleBuilder.quota(spannableStringBuilder);
            }
            prevLine.copyToNext();
            queue.prevLine().setStyle(spannableStringBuilder);
        }
        if (!quota(createChild) && !ul(createChild) && !ol(createChild) && !h(createChild)) {
            createChild.setStyle(SpannableStringBuilder.valueOf(createChild.getSource()));
            inline(createChild);
        } else if (createChild.getHandle() == 1) {
            if (line2.parentLine() == null) {
                int data = createChild.getData();
                StyleBuilder styleBuilder = this.styleBuilder;
                if (data == 2) {
                    line2.setStyle(styleBuilder.ul2(createChild.getStyle(), findCount(8, line2, 1) - 1, createChild.getAttr()));
                } else {
                    line2.setStyle(styleBuilder.ol2(createChild.getStyle(), findCount(8, line2, 1) - 1, createChild.getAttr(), createChild.getCount()));
                }
            } else {
                line2.setData(createChild.getData());
                line2.setStyle(createChild.getStyle());
                line2.setAttr(createChild.getAttr());
                line2.setCount(createChild.getCount());
                line2.setHandle(1);
            }
            return true;
        }
        line2.setStyle(this.styleBuilder.quota(createChild.getStyle()));
        return true;
    }

    @Override // com.zzhoujay.markdown.parser.QueueConsumer
    public void setQueueProvider(QueueConsumer.QueueProvider queueProvider) {
        this.queueProvider = queueProvider;
    }

    @Override // com.zzhoujay.markdown.parser.TagHandler
    public boolean ul(Line line) {
        return ul(line, 0);
    }
}
