This sample shows how to use SystemJS to support dependency loading via the import statement in TypeScript. Furthermore, it shows how to use SystemJS builder to compile the generated JS files, putting into consideration the dependency graph among the different modules.

One important thing that this sample tries to demontrate is that when the combined js file (`all.js`) is loaded, no other module is dynamically loaded, since `all.js` contain the definition of all modules. However, if `all.js` is not loaded, the individual modules will be loaded dynamically each time the module is requested.

To run the application, first install node packages:
```
npm install
```
Then execute grunt to execute TypeScript compiler followed by SystemJS builder to generate `all.js`
```
./node_modules/.bin/grunt
```
Finally, execute the dev server:
```
npm run dev
```