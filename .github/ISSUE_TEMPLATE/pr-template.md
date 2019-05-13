---
name: PR Template
about: All PRs must have this template
title: ''
labels: ''
assignees: ''

---

# PR Template

#### What does this change do?

#### Any additional information for the reviewer to start

#### How should this be manually tested?

#### Which Git Issue and subtask does this change relate to?

#### Are there any changes pending?

#### Definition of Done:
- [ ] Does the project compile ok?
- [ ] Is there a test case for every method written?  If it can’t be tested to provide proper reasons:
- [ ] Does it contain any unused variables, methods, and imports? If any, please remove it.

  For Backend:
- [ ] Is there >90% unit test code coverage?

  For Front-end:
- [ ] Is there >80% unit test code coverage?
- [ ] Does this PR require a wiki/knowledge base update? 
- [ ] Does this PR add new dependencies? If so, please list out the same:
- [ ] Will this feature require a new piece of infrastructure be implemented?
- [ ] Is there appropriate logging included?
- [ ] Is there a corresponding OpenAPI/swagger spec that has to be updated to reflect changes?
