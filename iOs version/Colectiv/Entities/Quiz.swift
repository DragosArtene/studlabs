//
//  Quiz.swift
//  Colectiv
//
//  Created by Andrei Lobont on 14/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

struct Quiz: Codable {
    let title: String
    let imageName: String
    let questions: [Question]
}
