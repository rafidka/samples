import os
import sys

if sys.version_info < (3, 0):
  input = raw_input

docs = []
prompt = 'Add a text document to index. When you are done with all documents, type "exit": '
while True:
  doc = input(prompt)
  if doc.lower() == 'exit':
    break
  docs.append(doc)

print(os.linesep)
print("Indexing the documents." + os.linesep)

index = {}
for doc_index, doc in enumerate(docs):
  for token in set(doc.split(' ')):
    if token in index:
      if doc_index not in index[token]:
        # We already have this token in the index, so simply add this document to it.
        index[token].append(doc_index)
    else:
      index[token] = [doc_index]

print("Finished indexing" + os.linesep)
print("Here is the index we built: ")
for key in index:
  print('Key "%s" contains the following documents: %s' % (key, str(index[key])))

# prompt = 'Enter your search query. When you are done, type "exit":'
# match_all_prompt = 'Should we find documents containing all tokens or any of them [Yes/No]:'
# while True:
#   # Prompt the user to enter a search query.
#   query = input(prompt)
#   if query.lower() == 'exit':
#     break
#   # Ask the user whether he/she wants to find documents containing all tokens.
#   match_all = True
#   while True:
#     answer = input(match_all_prompt)
#     if answer.lower() == 'yes':
#       match_all = True
#       break
#     elif answer.lower() == 'no':
#       match_all = False
#       break
#
#   # Build a list which contains the lists (that is, a list of lists) of
#   # documents matching the given tokens.
#   tokens = query.split(' ')
#   docs_lists = [docs for docs in index[tokens]]
#
#   # Depending on whether the user wants matching all tokens or any of them,
#   # we either intersect the lists of lists found above or union them.
#   if match_all:
#     matching_docs = set.intersection(*docs_lists)
#   else:
#     matching_docs = set.union(*docs_lists)
#   print('Documents with the following index matches your query: ' + str(matching_docs))

