import { Component, OnInit } from '@angular/core';
import {ForumItem} from '../../../model/ForumItem';



@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  items: ForumItem[];

  constructor(/*private forumService: ForumService*/) { }
  ngOnInit() {
    this.items = [
      {
        rating: 5,
        tags: ['algebra', 'groups'],
        // tslint:disable-next-line:max-line-length
        text: 'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. ',
        title: 'What is a group?',
        type: 'OPEN',
        comments: [{id: 1,
                    forumId: 0,
          // tslint:disable-next-line:max-line-length
                    text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
                    user: 'Mara'
                    },
          {id: 2,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 3,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 4,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 5,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 7,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 6,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
        ],
        username: 'Ana'
      },
      {
        rating: 4.5,
        tags: ['calculus', 'analysis', 'math'],
        // tslint:disable-next-line:max-line-length
        text: 'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. ',
        title: 'Is infinity infinite?',
        type: 'OPEN',
        comments: [{id: 1,
          forumId: 0,
          // tslint:disable-next-line:max-line-length
          text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
          user: 'Mara'
        },
          {id: 2,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 3,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 4,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 5,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 7,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 6,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
        ],
        username: 'Ana'
      },
      {
        rating: 5,
        tags: ['algebra', 'groups'],
        // tslint:disable-next-line:max-line-length
        text: 'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. ',
        title: 'skahfjasbf,jdbfkbc',
        type: 'OPEN',
        comments: [{id: 1,
          forumId: 0,
          // tslint:disable-next-line:max-line-length
          text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
          user: 'Mara'
        },
          {id: 2,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 3,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 4,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 5,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 7,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 6,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
        ],
        username: 'Ana'
      },
      {
        rating: 5,
        tags: ['algebra', 'groups'],
        // tslint:disable-next-line:max-line-length
        text: 'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. ',
        title: 'skahfjasbf,jdbfkbc',
        type: 'OPEN',
        comments: [{id: 1,
          forumId: 0,
          // tslint:disable-next-line:max-line-length
          text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
          user: 'Mara'
        },
          {id: 2,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 3,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 4,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 5,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 7,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 6,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
        ],
        username: 'Ana'
      },
      {
        rating: 5,
        tags: ['algebra','dhgfjsdab','dsjhfhsdkj', 'groups'],
        // tslint:disable-next-line:max-line-length
        text: 'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. ',
        title: 'skahfjasbf,jdbfkbc',
        type: 'OPEN',
        comments: [{id: 1,
          forumId: 0,
          // tslint:disable-next-line:max-line-length
          text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
          user: 'Mara'
        },
          {id: 2,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 3,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 4,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 5,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 7,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
          {id: 6,
            forumId: 0,
            // tslint:disable-next-line:max-line-length
            text: 'When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among',
            user: 'Mara'
          },
        ],
        username: 'Andreea'
      }
    ];
  }
}
