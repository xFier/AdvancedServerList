---
template: api-doc.html

methods:
  - name: 'get()'
    description: |
      Retrieve the instance used of this API.<br>
      If no instance has been made so far will a new one be created.
    returns: 'Instance of this API.'
    attributes:
      - static
    type:
      name: 'AdvancedServerListAPI'
      type: 'object'
  - name: 'addPlaceholderProvider(PlaceholderProvider)'
    description: |
      Adds the provided <a href="./../placeholderprovider/"><code>PlaceholderProvider</code></a> to the list, if it passes the following checks:<br>
      <ul>
        <li>Provided PlaceholderProvider instance is not null.</li>
        <li>The identifier is not null nor empty.</li>
        <li>The identifier does not contain any spaces.</li>
        <li>A PlaceholderProvider with the same identifier doesn't exist already.</li>
      </ul>
      Not passing any of the above checks results in a <a href="./../exceptions/invalidplaceholderproviderexception/"><code>InvalidPlaceholderProviderException</code></a> being thrown.
    parameters:
      - name: 'placeholderProvider'
        description: 'The <a href="./../placeholderprovider/"><code>PlaceholderProvider</code></a> to add.'
        attributes:
          - notnull
    throws:
      - name: 'InvalidPlaceholderProviderException'
        description: 'When the provided <a href="./../placeholderprovider/"><code>PlaceholderProvider</code> instance</a> is null, has a null or empty identifier, the identifier contains spaces, or another PlaceholderProvider with the same identifier is already in use.'
  - name: 'retrievePlaceholderProvider(String)'
    description: 'Retrieves the <a href="./../placeholderprovider/"><code>PlaceholderProvider</code></a> associated with the provided identifier, or <code>null</code> should no such entry exist.'
    parameters:
      - name: 'identifier'
        description: 'The identifier to find a matching <a href="./../placeholderprovider/"><code>PlaceholderProvider</code></a> for.'
    returns: 'Possibly-null <a href="./../placeholderprovider/"><code>PlaceholderProvider</code> instance</a>.'
    attributes:
      - nullable
---

# <api__class></api__class> AdvancedServerListAPI

Core class of the API for AdvancedServerList.  
Use [`get()`](#get) to retrieve the instance currently used.