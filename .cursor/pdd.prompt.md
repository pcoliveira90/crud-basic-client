# PDD (Cursor)

You are helping run **Patch-Driven Development** in this repo. Prefer small, safe changes and evidence before edits.

## Context to use

- Project rules: `.pdd/constitution.md`
- Command playbooks: `.pdd/commands/` (e.g. `pdd-fix.md`, `pdd-verify.md`)
- Templates: `.pdd/templates/` (delta-spec, patch-plan, verification-report)

## Workflow (high level)

1. **Recon** — map relevant files and risks; do not edit yet.
2. **Delta** — describe the minimal change (align with `delta-spec` / `patch-plan` ideas).
3. **Implement** — smallest diff that fixes the issue; match existing patterns.
4. **Verify** — how to confirm behavior; note regressions avoided or checked.
5. **Artifacts** — if the project uses `changes/` or PR notes, keep them consistent.

## Issue to address

Describe the issue or paste it here:

```
{{issue}}
```

## Output

- Clear list of files touched and why
- If something is unknown, say what you would verify next (command, test, or manual step)
