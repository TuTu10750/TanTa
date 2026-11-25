#!/bin/sh
# sync-and-push.sh —— 把 workspace 里新生成的测试文件同步到 GitHub 仓库并推送
#
# 用法：
#   sh /var/minis/workspace/tanta-repo/sync-and-push.sh "提交说明"
#
# 规则：
#   - hooks:   /var/minis/workspace/tanta-hook-v*.js  →  hooks/
#   - docs:    /var/minis/workspace/*.md（TANTA_ 开头）→  docs/
#               /var/minis/workspace/*_REVIEW/*.md     →  docs/<目录名>/
#   - rex:     /var/minis/workspace/tanta-v*.js        →  rex/
#   - captures: /var/minis/attachments/uploads/*.txt   →  captures/
#   - 排除：TANTA_ALL_P*.txt、TANTA_P*.txt（超大文本，不进仓库）

set -e
REPO=/var/minis/workspace/tanta-repo
WS=/var/minis/workspace
MSG="${1:-auto sync: $(date '+%Y-%m-%d %H:%M')}"

cd "$REPO"

# --- hooks ---
for f in "$WS"/tanta-hook-v*.js; do
  [ -f "$f" ] || continue
  cp -f "$f" hooks/ 2>/dev/null || true
done

# --- rex ---
for f in "$WS"/tanta-v*.js; do
  [ -f "$f" ] || continue
  cp -f "$f" rex/ 2>/dev/null || true
done

# --- docs: 顶层 TANTA_*.md ---
for f in "$WS"/TANTA_*.md; do
  [ -f "$f" ] || continue
  case "$f" in
    *TANTA_ALL_P*.txt|*TANTA_P[0-9]*.txt) continue ;;
  esac
  cp -f "$f" docs/ 2>/dev/null || true
done

# --- docs: 子目录报告 ---
for d in "$WS"/*_REVIEW "$WS"/PHASE*_*; do
  [ -d "$d" ] || continue
  base=$(basename "$d")
  mkdir -p "docs/$base"
  cp -f "$d"/*.md "docs/$base/" 2>/dev/null || true
done

# --- captures ---
for f in /var/minis/attachments/uploads/*明文*.txt /var/minis/attachments/uploads/*抓包*.md; do
  [ -f "$f" ] || continue
  cp -f "$f" captures/ 2>/dev/null || true
done

# --- git 提交推送 ---
git add -A
if git diff --cached --quiet; then
  echo "[skip] 没有新变更"
  exit 0
fi
git commit -q -m "$MSG"
echo "[commit] $MSG"
timeout 90 git push origin main 2>&1 | tail -4
echo "[push] 完成"
git log --oneline -1