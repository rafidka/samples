import {filter, map} from 'rxjs/operators';
import {range} from "rxjs";
import {of} from "rxjs/internal/observable/of";
import {zip} from "rxjs/internal/observable/zip";

console.log('Printing numbers from 1 to 20.')
range(1, 20).subscribe(x => console.log(x));

console.log('Printing numbers from 1 to 20, filtering out odd numbers.')
range(1, 20)
    .pipe(
        filter(x => x % 2 == 0)
    )
    .subscribe(x => console.log(x));

console.log('Zipping numbers and letters')
let nums = of(1, 2, 3, 4, 5);
let letters = of('a', 'b', 'c', 'd', 'e');
zip(nums, letters).pipe(map(x => '' + x[0] + x[1])).subscribe(x => console.log(x));

