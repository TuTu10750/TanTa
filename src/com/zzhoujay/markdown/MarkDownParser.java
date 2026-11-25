package com.zzhoujay.markdown;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.zzhoujay.markdown.parser.Line;
import com.zzhoujay.markdown.parser.LineQueue;
import com.zzhoujay.markdown.parser.QueueConsumer;
import com.zzhoujay.markdown.parser.StyleBuilder;
import com.zzhoujay.markdown.parser.TagHandler;
import com.zzhoujay.markdown.parser.TagHandlerImpl;
import com.zzhoujay.markdown.style.ScaleHeightSpan;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/classes2.dex */
class MarkDownParser {
    private BufferedReader reader;
    private TagHandler tagHandler;

    public MarkDownParser(BufferedReader bufferedReader, StyleBuilder styleBuilder) {
        this.reader = bufferedReader;
        this.tagHandler = new TagHandlerImpl(styleBuilder);
    }

    public MarkDownParser(InputStream inputStream, StyleBuilder styleBuilder) {
        this(new BufferedReader(new InputStreamReader(inputStream)), styleBuilder);
    }

    public MarkDownParser(String str, StyleBuilder styleBuilder) {
        this(new BufferedReader(new StringReader(str == null ? "" : str)), styleBuilder);
    }

    private LineQueue collect() {
        LineQueue lineQueue = null;
        Line line = null;
        while (true) {
            String readLine = this.reader.readLine();
            if (readLine == null) {
                return lineQueue;
            }
            if (!this.tagHandler.imageId(readLine) && !this.tagHandler.linkId(readLine)) {
                Line line2 = new Line(readLine);
                if (line == null) {
                    lineQueue = new LineQueue(line2);
                    line = line2;
                } else {
                    lineQueue.append(line2);
                }
            }
        }
    }

    private boolean findH1_2(LineQueue lineQueue, int i, String str) {
        String str2;
        if (!this.tagHandler.find(28, str)) {
            return false;
        }
        String source = lineQueue.currLine().getSource();
        Matcher matcher = Pattern.compile("^\\s{0,3}(>\\s+?){" + i + "}(.*)").matcher(source);
        if (matcher.find()) {
            int start = matcher.start(2);
            str2 = source.substring(0, start) + "# " + ((Object) source.subSequence(start, matcher.end(2)));
        } else {
            str2 = "# " + source;
        }
        lineQueue.currLine().setSource(str2);
        lineQueue.removeNextLine();
        return true;
    }

    private boolean findH2_2(LineQueue lineQueue, int i, String str) {
        String str2;
        if (!this.tagHandler.find(29, str)) {
            return false;
        }
        String source = lineQueue.currLine().getSource();
        Matcher matcher = Pattern.compile("^\\s{0,3}(>\\s+?){" + i + "}(.*)").matcher(lineQueue.currLine().getSource());
        if (matcher.find()) {
            int start = matcher.start(2);
            str2 = source.substring(0, start) + "## " + ((Object) source.subSequence(start, matcher.end(2)));
        } else {
            str2 = "## " + source;
        }
        lineQueue.currLine().setSource(str2);
        lineQueue.removeNextLine();
        return true;
    }

    private boolean handleQuotaRelevant(LineQueue lineQueue, boolean z) {
        int findCount = this.tagHandler.findCount(8, lineQueue.nextLine(), 1);
        int findCount2 = this.tagHandler.findCount(8, lineQueue.currLine(), 1);
        if (findCount > 0 && findCount > findCount2) {
            return true;
        }
        String source = lineQueue.nextLine().getSource();
        if (findCount > 0) {
            source = source.replaceFirst("^\\s{0,3}(>\\s+){" + findCount + "}", "");
        }
        if (findCount2 == findCount && (findH1_2(lineQueue, findCount2, source) || findH2_2(lineQueue, findCount2, source))) {
            return true;
        }
        if (z) {
            return false;
        }
        if (this.tagHandler.find(9, source) || this.tagHandler.find(10, source) || this.tagHandler.find(23, source)) {
            return true;
        }
        lineQueue.currLine().setSource(lineQueue.currLine().getSource() + ' ' + source);
        lineQueue.removeNextLine();
        return false;
    }

    private SpannableString listMarginBottom() {
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(new ScaleHeightSpan(0.4f), 0, spannableString.length(), 33);
        return spannableString;
    }

    private Spannable merge(LineQueue lineQueue) {
        lineQueue.reset();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        do {
            Line currLine = lineQueue.currLine();
            Line nextLine = lineQueue.nextLine();
            spannableStringBuilder.append(currLine.getStyle());
            if (nextLine == null) {
                break;
            }
            spannableStringBuilder.append('\n');
            int type = currLine.getType();
            if (type != 1) {
                if (type == 2) {
                    if (nextLine.getType() == 2) {
                        spannableStringBuilder.append((CharSequence) listMarginBottom());
                    }
                    spannableStringBuilder.append('\n');
                } else if (type != 3) {
                    spannableStringBuilder.append('\n');
                } else {
                    if (nextLine.getType() == 3) {
                        spannableStringBuilder.append((CharSequence) listMarginBottom());
                    }
                    spannableStringBuilder.append('\n');
                }
            } else if (nextLine.getType() != 1) {
                spannableStringBuilder.append('\n');
            }
        } while (lineQueue.next());
        return spannableStringBuilder;
    }

    private Spannable parse(final LineQueue lineQueue) {
        if (lineQueue == null) {
            return null;
        }
        this.tagHandler.setQueueProvider(new QueueConsumer.QueueProvider() { // from class: com.zzhoujay.markdown.MarkDownParser.1
            @Override // com.zzhoujay.markdown.parser.QueueConsumer.QueueProvider
            public LineQueue getQueue() {
                return lineQueue;
            }
        });
        removeCurrBlankLine(lineQueue);
        if (lineQueue.empty()) {
            return null;
        }
        do {
            if ((lineQueue.prevLine() != null && ((lineQueue.prevLine().getType() == 3 || lineQueue.prevLine().getType() == 2) && (this.tagHandler.find(9, lineQueue.currLine()) || this.tagHandler.find(10, lineQueue.currLine())))) || (!this.tagHandler.codeBlock1(lineQueue.currLine()) && !this.tagHandler.codeBlock2(lineQueue.currLine()))) {
                if (this.tagHandler.find(26, lineQueue.currLine()) || this.tagHandler.find(27, lineQueue.currLine()) || this.tagHandler.find(23, lineQueue.currLine())) {
                    if (lineQueue.nextLine() != null) {
                        handleQuotaRelevant(lineQueue, true);
                    }
                    removeNextBlankLine(lineQueue);
                    if (!this.tagHandler.gap(lineQueue.currLine()) && !this.tagHandler.quota(lineQueue.currLine()) && !this.tagHandler.ol(lineQueue.currLine()) && !this.tagHandler.ul(lineQueue.currLine()) && !this.tagHandler.h(lineQueue.currLine())) {
                        lineQueue.currLine().setStyle(SpannableStringBuilder.valueOf(lineQueue.currLine().getSource()));
                        this.tagHandler.inline(lineQueue.currLine());
                    }
                }
                while (lineQueue.nextLine() != null && !removeNextBlankLine(lineQueue) && !this.tagHandler.find(1, lineQueue.nextLine()) && !this.tagHandler.find(2, lineQueue.nextLine()) && !this.tagHandler.find(27, lineQueue.nextLine()) && !this.tagHandler.find(9, lineQueue.nextLine()) && !this.tagHandler.find(10, lineQueue.nextLine()) && !this.tagHandler.find(23, lineQueue.nextLine()) && !handleQuotaRelevant(lineQueue, false)) {
                }
                removeNextBlankLine(lineQueue);
                if (!this.tagHandler.gap(lineQueue.currLine())) {
                    lineQueue.currLine().setStyle(SpannableStringBuilder.valueOf(lineQueue.currLine().getSource()));
                    this.tagHandler.inline(lineQueue.currLine());
                }
            }
        } while (lineQueue.next());
        return merge(lineQueue);
    }

    private boolean removeCurrBlankLine(LineQueue lineQueue) {
        boolean z = false;
        while (lineQueue.currLine() != null && this.tagHandler.find(25, lineQueue.currLine())) {
            lineQueue.removeCurrLine();
            z = true;
        }
        return z;
    }

    private boolean removeNextBlankLine(LineQueue lineQueue) {
        boolean z = false;
        while (lineQueue.nextLine() != null && this.tagHandler.find(25, lineQueue.nextLine())) {
            lineQueue.removeNextLine();
            z = true;
        }
        return z;
    }

    public Spannable parse() {
        return parse(collect());
    }
}
