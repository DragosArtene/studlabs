//
//  Question.swift
//  Colectiv
//
//  Created by Andrei Lobont on 14/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

struct Question: Codable {
    let definition: String
    let answers: [Answer]
}
